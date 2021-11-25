    public static Tributacao findByTributProduct(String code, String modeloTributario, String modeloTributarioRef, String uf, String categoria) {
	    String modeloTributarioNew = "";
	    String modeloTributarioRefNew = "";

	    if(StringUtil.isNullOrEmpty(modeloTributario)){
            modeloTributarioNew = "" +modeloTributario;
        }else{
            modeloTributarioNew = ""+removeSpace(modeloTributario);
        }

        if(StringUtil.isNullOrEmpty(modeloTributarioRef)){
            modeloTributarioRefNew = "" +modeloTributarioRef;
        }else{
            modeloTributarioRefNew = ""+removeSpace(modeloTributarioRef);
        }

        //removeSpace(code) + "%", "%" + modeloTributarioNew + "%", "%" + modeloTributarioRefNew + "%", "%" + removeSpace(uf) + "%", "%" + removeSpace(categoria) + "%", "%").executeSingle();
        String sqlQueryPrint = SQLiteQueryBuilder.buildQueryString(false,"Tributacao", null, "code like "+ removeSpace(code), null, null, "code", null);
        Log.e("QUERY", "QUERY Tributacao... " +sqlQueryPrint);

        Log.e("err>>", "TRIBUTACAO>>>>>>> Code.:: " +code+ " / modelotrib.::" +modeloTributario+ " /modeloTribRef.::  " +modeloTributarioRef+ " / UF.:: " +uf+ " / categor.:: " +categoria);
        //return new Select().from(Tributacao.class).where(" code = ? and modeloTributario = ? and modeloTributarioRef = ? and uf = ? and categoria = ? and filial = ? ", removeSpace(code), modeloTributario, modeloTributarioRef, uf, categoria, filial).executeSingle();
        return new Select().from(Tributacao.class).where(" code LIKE ? AND modeloTributario LIKE ? AND modeloTributarioRef LIKE ? AND uf LIKE ? AND categoria LIKE ? AND filial LIKE ? ", "%" + removeSpace(code) + "%", "%" + modeloTributarioNew + "%", "%" + modeloTributarioRefNew + "%", "%" + removeSpace(uf) + "%", "%" + removeSpace(categoria) + "%", "%").executeSingle();
    }
