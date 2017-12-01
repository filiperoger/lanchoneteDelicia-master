package ws.domore.lanchonetedelicia;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

public class DetalheActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detalhe);

        Intent intent = DetalheActivity.this.getIntent();
        String produtoNome = "";
        String produtoPreco = "";
        String produtoDescricao = "";
        String produtoUrl = "";

        if (intent.hasExtra("produto_nome")){
            produtoNome = intent.getStringExtra("produto_nome");
        }
        TextView nome = (TextView) findViewById(R.id.idNome);
        nome.setText(produtoNome);

        if (intent.hasExtra("produto_preco")){
            produtoPreco = intent.getStringExtra("produto_preco");
        }
        TextView preco = (TextView) findViewById(R.id.idPreco);
        preco.setText(produtoPreco);

        if (intent.hasExtra("produto_descricao")){
            produtoDescricao = intent.getStringExtra("produto_descricao");
        }
        TextView descricao = (TextView) findViewById(R.id.idDescricao);
        descricao.setText(produtoDescricao);

        if (intent.hasExtra("produto_url")){
            produtoUrl = intent.getStringExtra("produto_url");
        }
        ImageView imageView = (ImageView) this.findViewById(R.id.idImage);
        Picasso.with(this).load(produtoUrl).into(imageView);
    }

    public void voltar(View view){
        finish();
    }
}
