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

        if (intent.hasExtra("myap")){
            produtoNome = intent.getStringExtra("myapp");
        }

        TextView textView = (TextView) findViewById(R.id.textView);
        textView.setText(produtoNome);
    }

    public void voltar(View view){
        finish();
    }
}
