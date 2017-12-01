package ws.domore.lanchonetedelicia;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.loopj.android.http.AsyncHttpClient;
import com.loopj.android.http.TextHttpResponseHandler;

import java.util.ArrayList;

import cz.msebera.android.httpclient.Header;

public class MainActivity extends AppCompatActivity {
    private Produto[] produtos;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Context context = this;
        String text = "Olá Filipe!!";
        int duration = Toast.LENGTH_SHORT;
        Toast toast = Toast.makeText(context, text, duration);
        toast.show();

        TextView textView = (TextView) this.findViewById(R.id.text_view_title);
        textView.setText(R.string.products_title);

        final ArrayList<String> produto_list = new ArrayList<String>();
        produto_list.add("Suco Onda Tropical");
        produto_list.add("Vitamina Planetaria");
        produto_list.add("Hamburguer Exagerado");
        produto_list.add("Pastel Super");
        produto_list.add("Empada Olho Grande");

        produtos = new Produto[5];
        produtos[0] = new Produto();
        produtos[0].setNome("Suco Onda Tropical");
        produtos[1] = new Produto();
        produtos[1].setNome("Vitamina Planetaria");
        produtos[2] = new Produto();
        produtos[2].setNome("Hamburguer Exagerado");
        produtos[3] = new Produto();
        produtos[3].setNome("Pastel Super");
        produtos[4] = new Produto();
        produtos[4].setNome("Empada Olho Grande");

        final ArrayAdapter<String> adapter = new ArrayAdapter<String>(
                this,
                R.layout.list_item_produto,
                R.id.text_view_produto,
                produto_list
        );

        ListView listView = (ListView) this.findViewById(R.id.list_view_produtos);
        listView.setAdapter(adapter);

        AsyncHttpClient client = new AsyncHttpClient();
        client.get(
                "https://patra-backend.appspot.com/produtos", new TextHttpResponseHandler() {

                    @Override
                    public void onFailure(int statusCode, Header[] headers, String responseString, Throwable throwable) {
                        Log.d("AsyncHttpClient", "response = " + responseString);
                    }

                    @Override
                    public void onSuccess(int statusCode, Header[] headers, String responseString) {
                        Log.d("AsyncHttpClient", "response = " + responseString);

                        Gson gson = new GsonBuilder().create();

                        produtos = gson.fromJson(responseString, Produto[].class);
                        adapter.clear();

                        for (Produto produto : produtos) {
                            adapter.add(produto.getNome());
                        }
                    }
                }
        );

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Intent detalheIntent = new Intent(MainActivity.this, DetalheActivity.class);
                detalheIntent.putExtra("produto_nome", produtos[i].getNome());
                detalheIntent.putExtra("produto_preco", produtos[i].getPreco());
                detalheIntent.putExtra("produto_descricao", produtos[i].getDescricao());
                detalheIntent.putExtra("produto_url", produtos[i].getImagem());
                startActivity(detalheIntent);
            }
        });
    }
}