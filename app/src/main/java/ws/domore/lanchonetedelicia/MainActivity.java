package ws.domore.lanchonetedelicia;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.preference.PreferenceActivity;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

import com.loopj.android.http.*;

import cz.msebera.android.httpclient.Header;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        AsyncHttpClient client = new AsyncHttpClient();
        client.get(
                "www.google.com.br", new TextHttpResponseHandler() {

                    @Override
                    public void onFailure(int statusCode, Header[] headers, String responseString, Throwable throwable) {
                        Log.d("AsyncHttpClient", "response = " + responseString);
                    }

                    @Override
                    public void onSuccess(int statusCode, Header[] headers, String responseString) {
                        Log.d("AsyncHttpClient", "response = " + responseString);
                    }
                }
        );

        TextView textView = (TextView) this.findViewById(R.id.text_view_title);
        textView.setText(R.string.products_title);

        final ArrayList<String> produto_list = new ArrayList<String>();

        produto_list.add("Suco Onda Tropical");
        produto_list.add("Vitamina Planetaria");
        produto_list.add("Hamburguer Exagerado");
        produto_list.add("Pastel Super");
        produto_list.add("Empada Olho Grande");
        produto_list.add("Boliviado Quente");
        produto_list.add("Quibe POP");
        produto_list.add("Esfirra do Sabor");
        produto_list.add("Crepioca Saborosa");
        produto_list.add("Pao de Nuvem");
        produto_list.add("Bruschetta Integral");
        produto_list.add("Banana chips");
        produto_list.add("Sopa Funcional");
        produto_list.add("Sanduche Natureba");
        produto_list.add("Salada  Surpresa");

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(
                this,
                R.layout.list_item_produto,
                R.id.text_view_produto,
                produto_list
        );

        ListView listView = (ListView) this.findViewById(R.id.list_view_produtos);

        listView.setAdapter(adapter);

        Context context = this;
        String text = "Olá Filipe!!";
        int duration = Toast.LENGTH_SHORT;
        Toast toast = Toast.makeText(context, text, duration);
        toast.show();

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Intent detalheIntent = new Intent(MainActivity.this, DetalheActivity.class);
                detalheIntent.putExtra("myapp", produto_list.get(i));
                startActivity(detalheIntent);
            }
        });
    }
}
