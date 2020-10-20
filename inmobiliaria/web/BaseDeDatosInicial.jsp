<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.util.Date"%>
<%@page import="Entidad.*"%>
<%@page import="Persistencia.*"%>
<%@page import="Vista.*"%>
<%
    //Base de datos inicial
    AccesoBD abd =new AccesoBD();
    try{
        abd.iniciarTransaccion(); 
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");


        //Barrio(String nombre,String ubicacion,String direccion)
        Barrio barrio1=new Barrio("Macro-centro","suroeste");
        abd.hacerPersistente(barrio1);
        Barrio barrio2=new Barrio("BandaNorte","norte");
        abd.hacerPersistente(barrio2);
        Barrio barrio3=new Barrio("Centro","sur");
        abd.hacerPersistente(barrio3);
        Barrio barrio4=new Barrio("Alberdi","este");
        abd.hacerPersistente(barrio4);
        
        Date fechaProp1 = sdf.parse("19/04/1989");
        Date fechaProp2 = sdf.parse("10/02/1982");
        Date fechaProp3 = sdf.parse("04/04/1984");
        Date fechaProp4 = sdf.parse("02/10/1974");
        Date fechaProp5 = sdf.parse("24/07/1997");
        Date fechaProp6 = sdf.parse("27/02/1947");
        Date fechaProp7 = sdf.parse("14/07/1968");
        
        //Propietario(String email,String nombre,String apellido,String dni,String direcc,String telFijo,String telMovil,String loc,String fechaNac)
        Propietario prop=new Propietario("JuanGomez@hotmail.com","Juan","Gomez","32421023","Ituzaingo 1314","358434567","15437867","Rio Cuarto",fechaProp1);
        abd.hacerPersistente(prop);
        Propietario prop2=new Propietario("MarioPP@hotmail.com","Mario","Muñis","33412039","San Juan 124","3584641222","15432867","Achiras",fechaProp2);
        abd.hacerPersistente(prop2);
        Propietario prop3=new Propietario("Rodrigo_10@gmail.com","Rodrigo","Juarez","32427123","Sarmiento 231","358434567","15435677","Rio Cuarto",fechaProp3);
        abd.hacerPersistente(prop3);
        Propietario prop4=new Propietario("Lea111@hotmail.com","Leandro","Echaide","30421273","Bs As 1314","358434567","15437867","Rio Cuarto",fechaProp4);
        abd.hacerPersistente(prop4);
        Propietario prop5=new Propietario("Vale_3911@hotmail.com","Valentin","Eleno","22421293","Roma 34","35843123","15497567","Rio Cuarto",fechaProp5);
        abd.hacerPersistente(prop5);
        Propietario prop6=new Propietario("JuanGomez@hotmail.com","Roberto","Guitierrez","30257955","Stgo del Estero 2314","358434341","154754567","Rio Cuarto",fechaProp6);
        abd.hacerPersistente(prop6);
        Propietario prop7=new Propietario("JuanGomez@hotmail.com","Pedro","Torres","32777555","Ituzaingo 854","358455657","154654667","Rio Cuarto",fechaProp7);
        abd.hacerPersistente(prop7);
        
        
        Date fechaAdm1 = sdf.parse("19/09/1989");
        Date fechaAdm2 = sdf.parse("11/11/1987");
        Date fechaAdm3 = sdf.parse("19/05/1979");
        /*Administrador(String email,String nombre,String apellido,String dni,String direcc,String telFijo,String telMovil,String loc,String fechaNac,String pagWeb, String usuario, String password)*/
        Administrador c = new Administrador("est@hotmail.com","Esteban","Ocampo","33046044","Sobremonte 1547","4621198","3584587469","Rio Cuarto",fechaAdm2,"www.estebanOcamp.com","esteban","esteban");
        abd.hacerPersistente(c);
        Administrador d = new Administrador("agu@gmail.com","Agustin","Perez Garcia","34771232","San Juan 1498","4641044","3584319532","Rio Cuarto",fechaAdm1,"www.agustinpg.com","agustin","agustin");
        abd.hacerPersistente(d);
        Administrador e = new Administrador("super@gmail.com","super","usuario","357778995","Buenos Aires 2832","4641048","3584319522","Rio Cuarto",fechaAdm3,"www.super.com","superusuario","superusuario");
        abd.hacerPersistente(e);
        
        Date fechaCliePos1 = sdf.parse("10/02/1959");
        Date fechaCliePos2 = sdf.parse("06/08/1990");

        //ClientePosible(String email,String nombre,String apellido,String dni,String direcc,String telFijo,String telMovil,String loc,String fechaNac, String operacion,long leInteresa,String nueva)
        ClientePosible cp =new ClientePosible("Gastonjki@hotmail.com","Gaston","Campo","21015841","Colon 933","45312628","154325456","Rio Cuarto",fechaCliePos1,"Comprar",3,"Nueva");
        abd.hacerPersistente(cp);
        ClientePosible cp1 =new ClientePosible("Joakin855@gmail.com","Joakin","Fernandez","23665477","La Rioja 433","45233273","153424678","Rio Cuarto",fechaCliePos2,"Comprar",1,"Nueva");
        abd.hacerPersistente(cp1);
      
        Date fechaClie1 = sdf.parse("10/04/1979");
        Date fechaClie2 = sdf.parse("15/10/1952");
        Date fechaClie3 = sdf.parse("20/01/1970");
        //Cliente(String email,String nombre,String apellido,String dni,String direcc,String telFijo,String telMovil,String loc,String fechaNac)
        Cliente cus=new Cliente("asd@fsd","Pepe","Gonzalez","33046044","Calle 14 1654","35842616","31221","Rio cuarto",fechaClie1);
        abd.hacerPersistente(cus);       
        Cliente cus1=new Cliente("kjkj@jb","Eufracio","Quintana","33046044","Calle 14 1654","35842616","1231","Rio cuarto",fechaClie2);
        abd.hacerPersistente(cus1);        
        Cliente cus3=new Cliente("hjgygvc@wer","Juana","Lopez","34771196","Calle 14 23","35842616","12389","Rio cuarto",fechaClie3);
        abd.hacerPersistente(cus3);
        
        Date fechaGar1 = sdf.parse("12/11/1956");
        Date fechaGar2 = sdf.parse("15/05/1982");
        Date fechaGar3 = sdf.parse("15/04/1997");
        /* Garante(String email,String nombre,String apellido,String dni,String direcc,String telFijo,String telMovil,String loc,String fechaNac, String profesion,String lugarTrabajo,String nacionalidad,Imagen reciboSueldo,Imagen impuestos,Imagen propiedades)*/
        Garante gar1 = new Garante("Gloria999@hotmail.com","Gloria","Estevez","33042383","Calle Publica 872","03584684342","15432672","Rio Cuarto",fechaGar1,"Abogada","Estudio Juridico Gomez","Argentina");
        abd.hacerPersistente(gar1);
        Garante gar2 = new Garante("Guille666@gmail.com","Guillermo","Gonzales","23043234","Corrientes 2451","03584632542","154324322","Rio Cuarto",fechaGar2,"Arquitecto","ConstruiR","Argentino");
        abd.hacerPersistente(gar2);
        Garante gar3 = new Garante("AgustoRaz@hotmail.com","Agusto","Razino","23239647","Mexico 795","035846734232","154887996","RioCuarto",fechaGar3,"Contador","AFIP","Argentina");
        abd.hacerPersistente(gar3);
        // public Inmueble(String operacion,Propietario posee,String tipo,int precio,String descr,Barrio tiene,String dire,String disponibilidad)

        //Inmueble(String operacion,Propietario posee,String tipo,int precio,String descr,String titulo,Barrio tiene,String dire,boolean disponibilidad,String monto)
        Inmueble inm1 = new Inmueble("Alquilar",prop,"Departamento",5450,"2 habitaciones, 2 baños, cocina integrada.",barrio1,"Laprida 1243","Disponible");
        abd.hacerPersistente(inm1);
        Inmueble inm2 = new Inmueble("Alquilar",prop2,"Casa",2300,"3 habitaciones, 2 baños, pileta, jacussi",barrio1,"San Lorenzo 3256","Disponible");
        abd.hacerPersistente(inm2);
        Inmueble inm3 = new Inmueble("Alquilar",prop3,"Departamento",2000,"4 habitaciones, 2 baños, ademas el edificio cuenta con gimnasio, quincho y pileta climatizada",barrio1,"Chacabuco 2334","Disponible");
        abd.hacerPersistente(inm3);
        Inmueble inm4 = new Inmueble("Alquilar",prop4,"Casa",3000,"2 habitacione,1 baño ",barrio1,"Las Heras 32","Disponible");
        abd.hacerPersistente(inm4);
        Inmueble inm5 = new Inmueble("Comprar",prop5,"Casa",300000,"1 Habitacion, 1 baño, Living-Comedor",barrio1,"Independecia 2345","Disponible");
        abd.hacerPersistente(inm5);
        Inmueble inm6 = new Inmueble("Comprar",prop6,"Casa",350000,"Mono-Ambiente",barrio4,"sobremobte 234","Disponible");
        abd.hacerPersistente(inm6);
         Inmueble inm7 = new Inmueble("Alquilar",prop,"Departamento",1500,"Mono-Ambiente",barrio1,"Muniz 2334","No Disponible");
        abd.hacerPersistente(inm7);
        Inmueble inm8 = new Inmueble("Alquilar",prop2,"Casa",4000,"2 habitaciones, 2 baño, balcon",barrio2,"España 243","No Disponible");
        abd.hacerPersistente(inm8);
        Inmueble inm9 = new Inmueble("Comprar",prop7,"Departamento",360000,"2 habitacione, 2 baños, living-comedor, lavadero",barrio3,"Parana 2354","No Disponible");
        abd.hacerPersistente(inm9);
        Inmueble inm10 = new Inmueble("Comprar",prop7,"Departamento",780000,"4 habitaciones, 3 baños, quincho, lavadero",barrio4,"Alvear 435","No Disponible");
        abd.hacerPersistente(inm10);

        // public Alquiler(String fecha,Cliente alquila,Inmueble alquilado,Administrador administra,Garante garantiza)
        Date fechaAlq1 = sdf.parse("08/02/2013");
        Date fechaAlq2 = sdf.parse("15/08/2010");
        Alquileres al1=new Alquileres(fechaAlq1,cus,inm7,c,gar1,2500);
        abd.hacerPersistente(al1);
        Alquileres al2=new Alquileres(fechaAlq2,cus1,inm8,d,gar2,4300);
        abd.hacerPersistente(al2);
        
        //Imagen(String path,Inmueble inm,String tipo)
        Imagen pic1=new Imagen("images/portadaBuscador/Prop1.jpg",inm1,"portada");
        abd.hacerPersistente(pic1);
        Imagen pic2=new Imagen("images/portadaBuscador/Prop2.jpg",inm2,"portada");
        abd.hacerPersistente(pic2);
        Imagen pic3=new Imagen("images/portadaBuscador/Prop3.jpg",inm3,"portada");
        abd.hacerPersistente(pic3);
        Imagen pic4=new Imagen("images/portadaBuscador/Prop4.jpg",inm4,"portada");
        abd.hacerPersistente(pic4);
        Imagen pic5=new Imagen("images/portadaBuscador/Prop5.jpg",inm6,"portada");
        abd.hacerPersistente(pic5);
        Imagen pic6=new Imagen("images/portadaBuscador/Prop6.jpg",inm5,"portada");
        abd.hacerPersistente(pic6);
        Imagen pic7=new Imagen("images/portadaBuscador/Prop7.jpg",inm8,"portada");
        abd.hacerPersistente(pic7);
        Imagen pic8=new Imagen("images/portadaBuscador/Prop8.jpg",inm9,"portada");
        abd.hacerPersistente(pic8);
        Imagen pic9=new Imagen("images/portadaBuscador/Prop9.jpg",inm10,"portada");
        abd.hacerPersistente(pic9);
        Imagen pic10=new Imagen("images/portadaBuscador/Prop10.jpg",inm10,"portada");
        abd.hacerPersistente(pic10);
               
        Imagen pic11=new Imagen("images/portadaAdministracion/Prop1.jpg",inm1,"partadaAd");
        abd.hacerPersistente(pic11);
        Imagen pic12=new Imagen("images/portadaAdministracion/Prop2.jpg",inm2,"partadaAd");
        abd.hacerPersistente(pic12);
        Imagen pic13=new Imagen("images/portadaAdministracion/Prop3.jpg",inm3,"partadaAd");
        abd.hacerPersistente(pic13);
        Imagen pic14=new Imagen("images/portadaAdministracion/Prop4.jpg",inm4,"partadaAd");
        abd.hacerPersistente(pic14);
        Imagen pic15=new Imagen("images/portadaAdministracion/Prop5.jpg",inm6,"partadaAd");
        abd.hacerPersistente(pic15);
        Imagen pic16=new Imagen("images/portadaAdministracion/Prop6.jpg",inm5,"partadaAd");
        abd.hacerPersistente(pic16);
        Imagen pic17=new Imagen("images/portadaAdministracion/Prop7.jpg",inm7,"partadaAd");
        abd.hacerPersistente(pic17);
        Imagen pic18=new Imagen("images/portadaAdministracion/Prop8.jpg",inm8,"partadaAd");
        abd.hacerPersistente(pic18);
        Imagen pic19=new Imagen("images/portadaAdministracion/Prop9.jpg",inm9,"partadaAd");
        abd.hacerPersistente(pic19);
        Imagen pic20=new Imagen("images/portadaAdministracion/Prop10.jpg",inm10,"partadaAd");
        abd.hacerPersistente(pic20);
        
        Imagen pic21=new Imagen("images/interiorCasas/Interior1Prop1.jpg",inm1,"imgDetalleGrande");
        abd.hacerPersistente(pic21);
        Imagen pic22=new Imagen("images/interiorCasas/Interior1Prop2.jpg",inm2,"imgDetalleGrande");
        abd.hacerPersistente(pic22);
        Imagen pic23=new Imagen("images/interiorCasas/Interior1Prop3.jpg",inm3,"imgDetalleGrande");
        abd.hacerPersistente(pic23);
        Imagen pic24=new Imagen("images/interiorCasas/Interior1Prop4.jpg",inm4,"imgDetalleGrande");
        abd.hacerPersistente(pic24);
        Imagen pic25=new Imagen("images/interiorCasas/Interior1Prop5.jpg",inm5,"imgDetalleGrande");
        abd.hacerPersistente(pic25);
        Imagen pic26=new Imagen("images/interiorCasas/Interior1Prop6.jpg",inm6,"imgDetalleGrande");
        abd.hacerPersistente(pic26);
        Imagen pic27=new Imagen("images/interiorCasas/Interior1Prop7.jpg",inm7,"imgDetalleGrande");
        abd.hacerPersistente(pic27);
        Imagen pic28=new Imagen("images/interiorCasas/Interior3Prop3.jpg",inm8,"imgDetalleGrande");
        abd.hacerPersistente(pic28);
        Imagen pic29=new Imagen("images/interiorCasas/Interior4Prop5.jpg",inm9,"imgDetalleGrande");
        abd.hacerPersistente(pic29);
        Imagen pic30=new Imagen("images/interiorCasas/Interior5Prop5.jpg",inm10,"imgDetalleGrande");
        abd.hacerPersistente(pic30);
        
        Imagen pic31=new Imagen("images/interiorCasas/Interior2Prop1.jpg",inm1,"imgDetalle1");
        abd.hacerPersistente(pic31);
        Imagen pic32=new Imagen("images/interiorCasas/Interior2Prop2.jpg",inm2,"imgDetalle1");
        abd.hacerPersistente(pic32);
        Imagen pic33=new Imagen("images/interiorCasas/Interior2Prop3.jpg",inm3,"imgDetalle1");
        abd.hacerPersistente(pic33);
        Imagen pic34=new Imagen("images/interiorCasas/Interior2Prop4.jpg",inm4,"imgDetalle1");
        abd.hacerPersistente(pic34);
        Imagen pic35=new Imagen("images/interiorCasas/Interior2Prop5.jpg",inm5,"imgDetalle1");
        abd.hacerPersistente(pic35);
        Imagen pic36=new Imagen("images/interiorCasas/Interior2Prop6.jpg",inm6,"imgDetalle1");
        abd.hacerPersistente(pic36);
        Imagen pic37=new Imagen("images/interiorCasas/Interior2Prop7.jpg",inm7,"imgDetalle1");
        abd.hacerPersistente(pic37);
        Imagen pic38=new Imagen("images/interiorCasas/Interior3Prop2.jpg",inm8,"imgDetalle1");
        abd.hacerPersistente(pic38);
        Imagen pic39=new Imagen("images/interiorCasas/Interior4Prop5.jpg",inm9,"imgDetalle1");
        abd.hacerPersistente(pic39);
        Imagen pic40=new Imagen("images/interiorCasas/Interior3Prop5.jpg",inm10,"imgDetalle1");
        abd.hacerPersistente(pic40);

        Imagen pic41=new Imagen("images/interiorCasas/Interior3Prop1.jpg",inm1,"imgDetalle2");
        abd.hacerPersistente(pic41);        
        Imagen pic42=new Imagen("images/interiorCasas/Interior3Prop2.jpg",inm2,"imgDetalle2");
        abd.hacerPersistente(pic42);        
        Imagen pic43=new Imagen("images/interiorCasas/Interior3Prop3.jpg",inm3,"imgDetalle2");
        abd.hacerPersistente(pic43);        
        Imagen pic44=new Imagen("images/interiorCasas/Interior3Prop4.jpg",inm4,"imgDetalle2");
        abd.hacerPersistente(pic44);        
        Imagen pic45=new Imagen("images/interiorCasas/Interior3Prop5.jpg",inm5,"imgDetalle2");
        abd.hacerPersistente(pic45);        
        Imagen pic46=new Imagen("images/interiorCasas/Interior3Prop6.jpg",inm6,"imgDetalle2");
        abd.hacerPersistente(pic46);        
        Imagen pic47=new Imagen("images/interiorCasas/Interior3Prop7.jpg",inm7,"imgDetalle2");
        abd.hacerPersistente(pic47);        
        Imagen pic48=new Imagen("images/interiorCasas/Interior1Prop1.jpg",inm8,"imgDetalle2");
        abd.hacerPersistente(pic48);        
        Imagen pic49=new Imagen("images/interiorCasas/Interior2Prop1.jpg",inm9,"imgDetalle2");
        abd.hacerPersistente(pic49);        
        Imagen pic50=new Imagen("images/interiorCasas/Interior3Prop1.jpg",inm10,"imgDetalle2");
        abd.hacerPersistente(pic50);        
  
        Imagen pic51=new Imagen("images/interiorCasas/Interior4Prop1.jpg",inm1,"imgDetalle3");
        abd.hacerPersistente(pic51);   
        Imagen pic52=new Imagen("images/interiorCasas/Interior4Prop2.jpg",inm2,"imgDetalle3");
        abd.hacerPersistente(pic52);   
        Imagen pic53=new Imagen("images/interiorCasas/Interior4Prop3.jpg",inm3,"imgDetalle3");
        abd.hacerPersistente(pic53);   
        Imagen pic54=new Imagen("images/interiorCasas/Interior4Prop4.jpg",inm4,"imgDetalle3");
        abd.hacerPersistente(pic54);  
        Imagen pic55=new Imagen("images/interiorCasas/Interior4Prop5.jpg",inm5,"imgDetalle3");
        abd.hacerPersistente(pic55);   
        Imagen pic56=new Imagen("images/interiorCasas/Interior4Prop6.jpg",inm6,"imgDetalle3");
        abd.hacerPersistente(pic56);   
        Imagen pic57=new Imagen("images/interiorCasas/Interior4Prop7.jpg",inm7,"imgDetalle3");
        abd.hacerPersistente(pic57);   
        Imagen pic58=new Imagen("images/interiorCasas/Interior3Prop1.jpg",inm8,"imgDetalle3");
        abd.hacerPersistente(pic58);  
        Imagen pic59=new Imagen("images/interiorCasas/Interior1Prop7.jpg",inm9,"imgDetalle3");
        abd.hacerPersistente(pic59);   
        Imagen pic60=new Imagen("images/interiorCasas/Interior1Prop6.jpg",inm10,"imgDetalle3");
        abd.hacerPersistente(pic60);  
        
        Imagen pic61=new Imagen("images/interiorCasas/Interior5Prop1.jpg",inm1,"imgDetalle4");
        abd.hacerPersistente(pic61); 
        Imagen pic62=new Imagen("images/interiorCasas/Interior5Prop2.jpg",inm2,"imgDetalle4");
        abd.hacerPersistente(pic62); 
        Imagen pic63=new Imagen("images/interiorCasas/Interior5Prop3.jpg",inm3,"imgDetalle4");
        abd.hacerPersistente(pic63); 
        Imagen pic64=new Imagen("images/interiorCasas/Interior5Prop4.jpg",inm4,"imgDetalle4");
        abd.hacerPersistente(pic64); 
        Imagen pic65=new Imagen("images/interiorCasas/Interior5Prop5.jpg",inm5,"imgDetalle4");
        abd.hacerPersistente(pic65); 
        Imagen pic66=new Imagen("images/interiorCasas/Interior5Prop6.jpg",inm6,"imgDetalle4");
        abd.hacerPersistente(pic66); 
        Imagen pic67=new Imagen("images/interiorCasas/Interior5Prop7.jpg",inm7,"imgDetalle4");
        abd.hacerPersistente(pic67); 
        Imagen pic68=new Imagen("images/interiorCasas/Interior5Prop1.jpg",inm8,"imgDetalle4");
        abd.hacerPersistente(pic68); 
        Imagen pic69=new Imagen("images/interiorCasas/Interior3Prop2.jpg",inm9,"imgDetalle4");
        abd.hacerPersistente(pic69); 
        Imagen pic70=new Imagen("images/interiorCasas/Interior4Prop6.jpg",inm10,"imgDetalle4");
        abd.hacerPersistente(pic70); 
        
        
        Date fechaVen1 = sdf.parse("04/06/2012");
        Date fechaVen2 = sdf.parse("16/02/2009");

        //Venta(String fecha,Cliente vende,Inmueble vendido,Administrador administra,String monto)
        //(venta no necesita monto porque lo tiene inmueble)
        Venta ven1=new Venta(fechaVen1,cus3,inm9,c,1500);
        abd.hacerPersistente(ven1);
        Venta ven2=new Venta(fechaVen1,cus1,inm10,c,3000);
        abd.hacerPersistente(ven2);

        abd.concretarTransaccion(); 
        
    response.sendRedirect("Index.jsp");

  }
    catch (Exception e) {
        String mensaje="<script language='javascript'>alert('Error al cargar la base de datos.');</script>"; 
        out.println(mensaje);
        abd.rollbackTransaccion();
        e.printStackTrace();
    }
    
    %>   
        <html>
            <head>
                <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
                <title>Cargando Ejemplos</title>
            </head>
            <body>
                <h1><a href="Index.jsp" target="_top">Ir a Index</a></h1>
            </body>
        </html>