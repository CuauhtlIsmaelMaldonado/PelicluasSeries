# PelicluasSeries
aplicacion java para ver peliculas y series

tuve problemas con la API  (logre  generar la cuenta ,el TOKEN  {"success":true,"expires_at":"2022-12-08 17:05:59 UTC","request_token":"14c333f83e35abc964377d3a195954548dc2c937"}

adjunto evidencia de que si pude consultar la información de una pelicula 
{"adult":false,"backdrop_path":"/hZkgoQYus5vegHoetLkCJzb17zJ.jpg","belongs_to_collection":null,"budget":63000000,"genres":[{"id":18,"name":"Drama"},{"id":53,"name":"Thriller"},{"id":35,"name":"Comedy"}],"homepage":"http://www.foxmovies.com/movies/fight-club","id":550,"imdb_id":"tt0137523","original_language":"en","original_title":"Fight Club","overview":"A ticking-time-bomb insomniac and a slippery soap salesman channel primal male aggression into a shocking new form of therapy. Their concept catches on, with underground \"fight clubs\" forming in every town, until an eccentric gets in the way and ignites an out-of-control spiral toward oblivion.","popularity":88.769,"poster_path":"/pB8BM7pdSp6B6Ih7QZ4DrQ3PmJK.jpg","production_companies":[{"id":508,"logo_path":"/7cxRWzi4LsVm4Utfpr1hfARNurT.png","name":"Regency Enterprises","origin_country":"US"},{"id":711,"logo_path":"/tEiIH5QesdheJmDAqQwvtN60727.png","name":"Fox 2000 Pictures","origin_country":"US"},{"id":4700,"logo_path":"/A32wmjrs9Psf4zw0uaixF0GXfxq.png","name":"The Linson Company","origin_country":"US"},{"id":20555,"logo_path":"/hD8yEGUBlHOcfHYbujp71vD8gZp.png","name":"Taurus Film","origin_country":"DE"},{"id":54051,"logo_path":null,"name":"Atman Entertainment","origin_country":""},{"id":54052,"logo_path":null,"name":"Knickerbocker Films","origin_country":"US"}],"production_countries":[{"iso_3166_1":"DE","name":"Germany"},{"iso_3166_1":"US","name":"United States of America"}],"release_date":"1999-10-15","revenue":100853753,"runtime":139,"spoken_languages":[{"english_name":"English","iso_639_1":"en","name":"English"}],"status":"Released","tagline":"Mischief. Mayhem. Soap.","title":"Fight Club","video":false,"vote_average":8.428,"vote_count":25281}
pero tuve problemas al consultar los metodos que traen todas las listas

desereavilizar el JSON  con una clases   usarla para con los mismos nombres poder hacer uso de la informacion ue traiga del consumo del API
como me mandan un JSON pensaba desereabilizarlo para que pudiera poner  la información en un  reciclerView -CardView  poner dentro al informacion de las peliculas o series,
todo esto lo hice(aria) mendiante Volley RequestQueue requestQueue , de iual manera  usar un CarouselView con un tiempo de 4 segundos para ue el usuario puda  ver  las series o peliculas que contiene.

para la coneion como mencione seria por Volley esta seria mas o menos la estructura
StringRequest stringRequest = new StringRequest(Request.Method.POST, url, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {

                Gson gson = new Gson();

                Login.Respuesta post = gson.fromJson(response, Login.Playing Now.class);

                for (playinNow soso: post.Peliculas){

                  // aqui traer todos los datos de las peliculas //

			agragrar a una lista ya teniendo la informacion

                    ListaPeliculas;

                }

                ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(getApplicationContext(),R.layout.spinner_item,ListaPeliculas;)
              
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(getApplicationContext(),"no funciona "+error, Toast.LENGTH_SHORT).show();
            }
        }){
            @NonNull
            @Override
            protected Map<String,String> getParams(){
                Map<String,String> params = new HashMap<String,String>();
                
		// poner los parametros que me solicitan para consimir el API
			params.put("opcion","1");
                return params;
            }
            @NonNull
            @Override
            public Map<String,String> getHeaders()throws AuthFailureError {
                Map<String,String> params=new HashMap<String,String>();

			// parametros que son el usuario y el pasword //
                params.put("user","ACVprogrammer");
                params.put("pass","V=.a{Xf}e0CR");
                return params;
            }
        };

        requestQueue.add(stringRequest);
        
