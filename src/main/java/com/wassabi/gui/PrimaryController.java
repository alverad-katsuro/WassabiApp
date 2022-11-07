package com.wassabi.gui;

import java.io.IOException;
import java.net.URL;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

import javax.swing.JOptionPane;

import com.wassabi.dao.ProdutoDAO;
import com.wassabi.dao.UsuarioDAO;
import com.wassabi.dao.VendaDAO;
import com.wassabi.model.Produto;
import com.wassabi.model.Venda;
import com.wassabi.model.VendaHasProduto;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TabPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;

public class PrimaryController implements Initializable {
    @FXML private TabPane tbRoot;
    @FXML private Pane P_block;
    @FXML private VBox listaProdutos;
    @FXML private VBox listaSacola;
    @FXML private VBox listaVendas;
    @FXML private Venda venda = new Venda();
    @FXML private List<VendaHasProduto> produtos = new ArrayList<VendaHasProduto>();
    private Double preco_fim = 0D;


    @Override
    public void initialize(URL arg0, ResourceBundle arg1) {
        createProdutoView();
        createVendasView();
    }
    
    /** 
     * @return Pane
     */
    protected Pane getP_block() {
        return P_block;
    }

    /** 
     * @param p_block
     */
    protected void setP_block(Pane p_block) {
        P_block = p_block;
    }

    protected void setP_block(String fxml){
        this.P_block.getChildren().clear();
        try {
            this.P_block.getChildren().add(AppFX.loadFXML(fxml));
        } catch (IOException e) {
            System.out.println("Erro setP_block - PrimaryController");
            e.printStackTrace();
        }
    }

    /*
     * 
     */
    protected void setP_block(Parent parent){
        this.P_block.getChildren().clear();
        this.P_block.getChildren().add(parent);
    }



    @FXML
    private void switchToVendaFind() throws IOException {
        AppFX.setRoot("vendaCreateUpdate");
    }

    @FXML
    private void createSacolaView(){
        this.listaSacola.getChildren().clear();

        HBox controls_preco = new HBox();
        this.preco_fim = 0D;
        Label preco_final = new Label();
        preco_final.setMinSize(this.tbRoot.getMinWidth() * 0.7,0);
        Button finalizarCompra = new Button("Finalizar Compra");
        finalizarCompra.setOnAction(ev ->{
            venda.setCliente(AppFX.getUsuario_autenticado().getCliente());
            VendaDAO.createVenda(venda);
            JOptionPane.showMessageDialog(null, "Compra Realizada com sucesso!", "Compra Realizada", JOptionPane.INFORMATION_MESSAGE);
            this.venda = new Venda();
            this.produtos.clear();
            createProdutoView();
            createVendasView();
            this.tbRoot.getSelectionModel().select(2);          
        });
        
        controls_preco.getChildren().addAll(preco_final, finalizarCompra);

    
        for (VendaHasProduto produtovenda : this.venda.getVendaHasProdutos()) {
            GridPane container = new GridPane();
            this.preco_fim += produtovenda.getQuantidade() * produtovenda.getProduto().getProdutoPreco();

            Label produto_quantidade = new Label(String.format("  %d  ", produtovenda.getQuantidade()));
            
            Button incrementa = new Button(">");
            incrementa.setOnAction(ev -> {
                preco_final.setText(String.format("O preço final é R$%.2f", this.preco_fim));
                produtovenda.incrementaProduto();
                this.preco_fim += produtovenda.getProduto().getProdutoPreco();
                produto_quantidade.setText(String.format("  %d  ", produtovenda.getQuantidade()));
            });
            
            Button decrementa = new Button("<");
            decrementa.setOnAction(ev -> {
                if (produtovenda.getQuantidade() > 0) {
                    if(produtovenda.getQuantidade() == 1 && this.venda.getVendaHasProdutos().contains(produtovenda)){
                        this.venda.getVendaHasProdutos().remove(produtovenda);
                        this.listaSacola.getChildren().remove(container);
                    }
                    this.preco_fim -= produtovenda.getProduto().getProdutoPreco();
                    produtovenda.decrementaProduto();
                    produto_quantidade.setText(String.format("  %d  ", produtovenda.getQuantidade()));
                    preco_final.setText(String.format("O preço final é R$%.2f", this.preco_fim));
                }
            });
    
            VBox produto_box = new VBox();
            
            produto_box.setMinSize(this.tbRoot.getPrefWidth() * 0.70, 82.0);
            produto_box.getChildren().add(new Label(produtovenda.getProduto().getProdutoNome()));
            produto_box.getChildren().add(new Label(produtovenda.getProduto().getCategoria().getCategoriaNome()));
            produto_box.getChildren().add(new Label(produtovenda.getProduto().getProdutoDescricao()));
            produto_box.getChildren().add(new Label(String.format("Preço unitario R$%.2f", produtovenda.getProduto().getProdutoPreco())));
    
            HBox produto_botoes = new HBox();
            produto_botoes.setAlignment(Pos.CENTER);
            produto_botoes.getChildren().addAll(decrementa, produto_quantidade, incrementa);
    
            container.add(produto_box, 0, 0);
            container.addColumn(1, produto_botoes);

            listaSacola.getChildren().add(container);
        }
        preco_final.setText(String.format("O preço final é R$%.2f", this.preco_fim));
        this.listaSacola.getChildren().addAll(controls_preco);

    }


    @FXML
    private void createVendasView(){
        this.listaVendas.getChildren().clear();
    
        for (Venda venda : VendaDAO.readVendas()) {
            GridPane container = new GridPane();
            VBox produto_box = new VBox();
            
            produto_box.setMinSize(this.tbRoot.getPrefWidth(), 82.0);
            produto_box.getChildren().add(new Label("Data da Compra " + Date.from(venda.getVendaData().toInstant())));
            venda.getVendaHasProdutos().forEach(prod -> {
                produto_box.getChildren().add(new Label(String.format("%s, quantidade %d",prod.getProduto().getProdutoNome(), prod.getQuantidade())));
            });
            produto_box.getChildren().add(new Label(String.format("Preço unitario R$%.2f", venda.getVendaTotal())));

    
            container.add(produto_box, 0, 0);

            listaVendas.getChildren().add(container);
        }
    }


    @FXML
    private void updateProdutoView(){
        this.listaProdutos.getChildren().clear();
        for (VendaHasProduto produtovenda : this.produtos) {
            GridPane container = new GridPane();
            HBox produto_botoes = new HBox();
            produto_botoes.setAlignment(Pos.CENTER);
            VBox produto_box = new VBox();

            Label produto_quantidade = new Label(String.format("  %d  ", produtovenda.getQuantidade()));
                  
            produto_box.setMinSize(this.tbRoot.getPrefWidth() * 0.70, 82.0);
            produto_box.getChildren().add(new Label(produtovenda.getProduto().getProdutoNome()));
            produto_box.getChildren().add(new Label(produtovenda.getProduto().getCategoria().getCategoriaNome()));
            produto_box.getChildren().add(new Label(produtovenda.getProduto().getProdutoDescricao()));
            produto_box.getChildren().add(new Label(String.format("Preço unitario R$%.2f", produtovenda.getProduto().getProdutoPreco())));
            
            
            Button incrementa = new Button(">");
            incrementa.setOnAction(ev -> {
                if(!this.venda.getVendaHasProdutos().contains(produtovenda)){
                    this.venda.addProduto(produtovenda);
                }
                produtovenda.incrementaProduto();
                produto_quantidade.setText(String.format("  %d  ", produtovenda.getQuantidade()));
            });
            

            Button decrementa = new Button("<");
            decrementa.setOnAction(ev -> {
                if (produtovenda.getQuantidade() > 0) {
                    if(produtovenda.getQuantidade() == 1 && this.venda.getVendaHasProdutos().contains(produtovenda)){
                        this.venda.getVendaHasProdutos().remove(produtovenda);
                    }
                    produtovenda.decrementaProduto();
                    produto_quantidade.setText(String.format("  %d  ", produtovenda.getQuantidade()));
                }
            });
    
            
            produto_botoes.getChildren().addAll(decrementa, produto_quantidade, incrementa);
    
            container.add(produto_box, 0, 0);
            container.addColumn(1, produto_botoes);

            listaProdutos.getChildren().add(container);
        }
    }


    private void createProdutoView(){
        for (Produto produto : ProdutoDAO.readProdutos()) {
            GridPane container = new GridPane();
            HBox produto_botoes = new HBox();
            produto_botoes.setAlignment(Pos.CENTER);
            VBox produto_box = new VBox();
            Label produto_quantidade = new Label("  0  ");
            VendaHasProduto produtovenda = new VendaHasProduto(produto, 0);
            this.produtos.add(produtovenda);
                    
            produto_box.setMinSize(this.tbRoot.getPrefWidth() * 0.70, 82.0);
            produto_box.getChildren().add(new Label(produto.getProdutoNome()));
            produto_box.getChildren().add(new Label(produto.getCategoria().getCategoriaNome()));
            produto_box.getChildren().add(new Label(produto.getProdutoDescricao()));
            produto_box.getChildren().add(new Label(String.format("Preço unitario R$%.2f", produto.getProdutoPreco())));
            
            
            Button incrementa = new Button(">");
            incrementa.setOnAction(ev -> {
                if(!this.venda.getVendaHasProdutos().contains(produtovenda)){
                    this.venda.addProduto(produtovenda);
                }
                produtovenda.incrementaProduto();
                produto_quantidade.setText(String.format("  %d  ", produtovenda.getQuantidade()));
            });
            

            Button decrementa = new Button("<");
            decrementa.setOnAction(ev -> {
                if (produtovenda.getQuantidade() > 0) {
                    if(produtovenda.getQuantidade() == 1 && this.venda.getVendaHasProdutos().contains(produtovenda)){
                        this.venda.getVendaHasProdutos().remove(produtovenda);
                    }
                    produtovenda.decrementaProduto();
                    produto_quantidade.setText(String.format("  %d  ", produtovenda.getQuantidade()));
                }
            });
    
            
            produto_botoes.getChildren().addAll(decrementa, produto_quantidade, incrementa);
    
            container.add(produto_box, 0, 0);
            container.addColumn(1, produto_botoes);

            listaProdutos.getChildren().add(container);
        }
    }
}
