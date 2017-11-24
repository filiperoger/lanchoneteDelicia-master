package ws.domore.lanchonetedelicia;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class DetalheActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detalhe);

        Intent intent = DetalheActivity.this.getIntent();
        String produtoNome = "";

        if (intent.hasExtra("produto_nome")){
            produtoNome = intent.getStringExtra("produto_nome");
        }

        TextView textView = (TextView) findViewById(R.id.idNome);
        textView.setText(produtoNome);
    }

    public void voltar(View view){
        finish();
    }
}
