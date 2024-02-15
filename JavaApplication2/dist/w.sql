PGDMP     '    "                {            bahai    15.1    15.1 j    o           0    0    ENCODING    ENCODING        SET client_encoding = 'UTF8';
                      false            p           0    0 
   STDSTRINGS 
   STDSTRINGS     (   SET standard_conforming_strings = 'on';
                      false            q           0    0 
   SEARCHPATH 
   SEARCHPATH     8   SELECT pg_catalog.set_config('search_path', '', false);
                      false            r           1262    16601    bahai    DATABASE     x   CREATE DATABASE bahai WITH TEMPLATE = template0 ENCODING = 'UTF8' LOCALE_PROVIDER = libc LOCALE = 'French_France.1252';
    DROP DATABASE bahai;
                postgres    false            �            1259    16602    achat    TABLE     �   CREATE TABLE public.achat (
    id_achat integer NOT NULL,
    id_fournisser integer NOT NULL,
    houreachat time with time zone,
    totale bigint,
    dateachat text
);
    DROP TABLE public.achat;
       public         heap    postgres    false            �            1259    16607    achat_id_achat_seq    SEQUENCE     �   CREATE SEQUENCE public.achat_id_achat_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
 )   DROP SEQUENCE public.achat_id_achat_seq;
       public          postgres    false    214            s           0    0    achat_id_achat_seq    SEQUENCE OWNED BY     I   ALTER SEQUENCE public.achat_id_achat_seq OWNED BY public.achat.id_achat;
          public          postgres    false    215            �            1259    16608    achat_id_cleint_seq    SEQUENCE     �   CREATE SEQUENCE public.achat_id_cleint_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
 *   DROP SEQUENCE public.achat_id_cleint_seq;
       public          postgres    false    214            t           0    0    achat_id_cleint_seq    SEQUENCE OWNED BY     O   ALTER SEQUENCE public.achat_id_cleint_seq OWNED BY public.achat.id_fournisser;
          public          postgres    false    216            �            1259    16609    bonr    TABLE     �   CREATE TABLE public.bonr (
    "NBR" integer NOT NULL,
    quntite bigint NOT NULL,
    datea date NOT NULL,
    prixuntaire numeric NOT NULL,
    prixtotal numeric NOT NULL,
    designtion character varying,
    nom character varying
);
    DROP TABLE public.bonr;
       public         heap    postgres    false            �            1259    16614    bonr_NBR_seq    SEQUENCE     �   CREATE SEQUENCE public."bonr_NBR_seq"
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
 %   DROP SEQUENCE public."bonr_NBR_seq";
       public          postgres    false    217            u           0    0    bonr_NBR_seq    SEQUENCE OWNED BY     A   ALTER SEQUENCE public."bonr_NBR_seq" OWNED BY public.bonr."NBR";
          public          postgres    false    218            �            1259    16615    client    TABLE     �   CREATE TABLE public.client (
    nc bigint NOT NULL,
    nom text NOT NULL,
    mobile bigint NOT NULL,
    email text,
    adrasse text,
    nrc text,
    ai text,
    aif text,
    nis text,
    tin text,
    remise bigint
);
    DROP TABLE public.client;
       public         heap    postgres    false            �            1259    16620    client_nc_seq    SEQUENCE     �   CREATE SEQUENCE public.client_nc_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
 $   DROP SEQUENCE public.client_nc_seq;
       public          postgres    false    219            v           0    0    client_nc_seq    SEQUENCE OWNED BY     ?   ALTER SEQUENCE public.client_nc_seq OWNED BY public.client.nc;
          public          postgres    false    220            �            1259    16621    deatilsfactures    TABLE       CREATE TABLE public.deatilsfactures (
    id_datailsfacture integer NOT NULL,
    id_facture integer NOT NULL,
    id_produit integer NOT NULL,
    quntite bigint NOT NULL,
    prixvente bigint NOT NULL,
    montant bigint,
    totale text,
    "user" text,
    produit text
);
 #   DROP TABLE public.deatilsfactures;
       public         heap    postgres    false            �            1259    16626 $   deatilsfacures_id_datailsfacture_seq    SEQUENCE     �   CREATE SEQUENCE public.deatilsfacures_id_datailsfacture_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
 ;   DROP SEQUENCE public.deatilsfacures_id_datailsfacture_seq;
       public          postgres    false    221            w           0    0 $   deatilsfacures_id_datailsfacture_seq    SEQUENCE OWNED BY     n   ALTER SEQUENCE public.deatilsfacures_id_datailsfacture_seq OWNED BY public.deatilsfactures.id_datailsfacture;
          public          postgres    false    222            �            1259    16627    deatilsfacures_id_facture_seq    SEQUENCE     �   CREATE SEQUENCE public.deatilsfacures_id_facture_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
 4   DROP SEQUENCE public.deatilsfacures_id_facture_seq;
       public          postgres    false    221            x           0    0    deatilsfacures_id_facture_seq    SEQUENCE OWNED BY     `   ALTER SEQUENCE public.deatilsfacures_id_facture_seq OWNED BY public.deatilsfactures.id_facture;
          public          postgres    false    223            �            1259    16628    deatilsfacures_id_produit_seq    SEQUENCE     �   CREATE SEQUENCE public.deatilsfacures_id_produit_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
 4   DROP SEQUENCE public.deatilsfacures_id_produit_seq;
       public          postgres    false    221            y           0    0    deatilsfacures_id_produit_seq    SEQUENCE OWNED BY     `   ALTER SEQUENCE public.deatilsfacures_id_produit_seq OWNED BY public.deatilsfactures.id_produit;
          public          postgres    false    224            �            1259    16629    detailsachat    TABLE     �   CREATE TABLE public.detailsachat (
    id_detailsachat integer NOT NULL,
    id_produit integer NOT NULL,
    id_achat integer NOT NULL,
    prixacaht bigint,
    qnte bigint,
    montant bigint
);
     DROP TABLE public.detailsachat;
       public         heap    postgres    false            �            1259    16632    detailsachat_id_achat_seq    SEQUENCE     �   CREATE SEQUENCE public.detailsachat_id_achat_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
 0   DROP SEQUENCE public.detailsachat_id_achat_seq;
       public          postgres    false    225            z           0    0    detailsachat_id_achat_seq    SEQUENCE OWNED BY     W   ALTER SEQUENCE public.detailsachat_id_achat_seq OWNED BY public.detailsachat.id_achat;
          public          postgres    false    226            �            1259    16633     detailsachat_id_detailsachat_seq    SEQUENCE     �   CREATE SEQUENCE public.detailsachat_id_detailsachat_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
 7   DROP SEQUENCE public.detailsachat_id_detailsachat_seq;
       public          postgres    false    225            {           0    0     detailsachat_id_detailsachat_seq    SEQUENCE OWNED BY     e   ALTER SEQUENCE public.detailsachat_id_detailsachat_seq OWNED BY public.detailsachat.id_detailsachat;
          public          postgres    false    227            �            1259    16634    detailsachat_id_produit_seq    SEQUENCE     �   CREATE SEQUENCE public.detailsachat_id_produit_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
 2   DROP SEQUENCE public.detailsachat_id_produit_seq;
       public          postgres    false    225            |           0    0    detailsachat_id_produit_seq    SEQUENCE OWNED BY     [   ALTER SEQUENCE public.detailsachat_id_produit_seq OWNED BY public.detailsachat.id_produit;
          public          postgres    false    228            �            1259    16635    facturs    TABLE     �   CREATE TABLE public.facturs (
    id_facture integer NOT NULL,
    datefacture text,
    heuer text,
    id_client bigint,
    montant bigint
);
    DROP TABLE public.facturs;
       public         heap    postgres    false            �            1259    16640    facturs_id_facture_seq    SEQUENCE     �   CREATE SEQUENCE public.facturs_id_facture_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
 -   DROP SEQUENCE public.facturs_id_facture_seq;
       public          postgres    false    229            }           0    0    facturs_id_facture_seq    SEQUENCE OWNED BY     Q   ALTER SEQUENCE public.facturs_id_facture_seq OWNED BY public.facturs.id_facture;
          public          postgres    false    230            �            1259    16641    fournisseur    TABLE     �   CREATE TABLE public.fournisseur (
    nf integer NOT NULL,
    nom text NOT NULL,
    mobile bigint NOT NULL,
    email text,
    adrasse text,
    nrc text,
    ai text,
    aif text,
    nis text,
    tin text
);
    DROP TABLE public.fournisseur;
       public         heap    postgres    false            �            1259    16646    fournisseur_NF_seq    SEQUENCE     �   CREATE SEQUENCE public."fournisseur_NF_seq"
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
 +   DROP SEQUENCE public."fournisseur_NF_seq";
       public          postgres    false    231            ~           0    0    fournisseur_NF_seq    SEQUENCE OWNED BY     K   ALTER SEQUENCE public."fournisseur_NF_seq" OWNED BY public.fournisseur.nf;
          public          postgres    false    232            �            1259    16647    login    TABLE     �   CREATE TABLE public.login (
    idu integer NOT NULL,
    nom character varying NOT NULL,
    pass character varying NOT NULL,
    type character varying NOT NULL
);
    DROP TABLE public.login;
       public         heap    postgres    false            �            1259    16652    login_idu_seq    SEQUENCE     �   CREATE SEQUENCE public.login_idu_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
 $   DROP SEQUENCE public.login_idu_seq;
       public          postgres    false    233                       0    0    login_idu_seq    SEQUENCE OWNED BY     ?   ALTER SEQUENCE public.login_idu_seq OWNED BY public.login.idu;
          public          postgres    false    234            �            1259    16653    produit    TABLE     �   CREATE TABLE public.produit (
    id_mt integer NOT NULL,
    disgnation character varying,
    prixvent bigint,
    prixachat bigint,
    qnt bigint
);
    DROP TABLE public.produit;
       public         heap    postgres    false            �            1259    16658    matierep_NMP_seq    SEQUENCE     �   CREATE SEQUENCE public."matierep_NMP_seq"
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
 )   DROP SEQUENCE public."matierep_NMP_seq";
       public          postgres    false    235            �           0    0    matierep_NMP_seq    SEQUENCE OWNED BY     H   ALTER SEQUENCE public."matierep_NMP_seq" OWNED BY public.produit.id_mt;
          public          postgres    false    236            �            1259    16659    servise    TABLE     ]   CREATE TABLE public.servise (
    id_ser integer NOT NULL,
    nom text,
    prixs bigint
);
    DROP TABLE public.servise;
       public         heap    postgres    false            �            1259    16664    servise_id_ser_seq    SEQUENCE     �   CREATE SEQUENCE public.servise_id_ser_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
 )   DROP SEQUENCE public.servise_id_ser_seq;
       public          postgres    false    237            �           0    0    servise_id_ser_seq    SEQUENCE OWNED BY     I   ALTER SEQUENCE public.servise_id_ser_seq OWNED BY public.servise.id_ser;
          public          postgres    false    238            �           2604    16665    achat id_achat    DEFAULT     p   ALTER TABLE ONLY public.achat ALTER COLUMN id_achat SET DEFAULT nextval('public.achat_id_achat_seq'::regclass);
 =   ALTER TABLE public.achat ALTER COLUMN id_achat DROP DEFAULT;
       public          postgres    false    215    214            �           2604    16666    achat id_fournisser    DEFAULT     v   ALTER TABLE ONLY public.achat ALTER COLUMN id_fournisser SET DEFAULT nextval('public.achat_id_cleint_seq'::regclass);
 B   ALTER TABLE public.achat ALTER COLUMN id_fournisser DROP DEFAULT;
       public          postgres    false    216    214            �           2604    16667    bonr NBR    DEFAULT     h   ALTER TABLE ONLY public.bonr ALTER COLUMN "NBR" SET DEFAULT nextval('public."bonr_NBR_seq"'::regclass);
 9   ALTER TABLE public.bonr ALTER COLUMN "NBR" DROP DEFAULT;
       public          postgres    false    218    217            �           2604    16668 	   client nc    DEFAULT     f   ALTER TABLE ONLY public.client ALTER COLUMN nc SET DEFAULT nextval('public.client_nc_seq'::regclass);
 8   ALTER TABLE public.client ALTER COLUMN nc DROP DEFAULT;
       public          postgres    false    220    219            �           2604    16669 !   deatilsfactures id_datailsfacture    DEFAULT     �   ALTER TABLE ONLY public.deatilsfactures ALTER COLUMN id_datailsfacture SET DEFAULT nextval('public.deatilsfacures_id_datailsfacture_seq'::regclass);
 P   ALTER TABLE public.deatilsfactures ALTER COLUMN id_datailsfacture DROP DEFAULT;
       public          postgres    false    222    221            �           2604    16670    deatilsfactures id_facture    DEFAULT     �   ALTER TABLE ONLY public.deatilsfactures ALTER COLUMN id_facture SET DEFAULT nextval('public.deatilsfacures_id_facture_seq'::regclass);
 I   ALTER TABLE public.deatilsfactures ALTER COLUMN id_facture DROP DEFAULT;
       public          postgres    false    223    221            �           2604    16671    deatilsfactures id_produit    DEFAULT     �   ALTER TABLE ONLY public.deatilsfactures ALTER COLUMN id_produit SET DEFAULT nextval('public.deatilsfacures_id_produit_seq'::regclass);
 I   ALTER TABLE public.deatilsfactures ALTER COLUMN id_produit DROP DEFAULT;
       public          postgres    false    224    221            �           2604    16672    detailsachat id_detailsachat    DEFAULT     �   ALTER TABLE ONLY public.detailsachat ALTER COLUMN id_detailsachat SET DEFAULT nextval('public.detailsachat_id_detailsachat_seq'::regclass);
 K   ALTER TABLE public.detailsachat ALTER COLUMN id_detailsachat DROP DEFAULT;
       public          postgres    false    227    225            �           2604    16673    detailsachat id_produit    DEFAULT     �   ALTER TABLE ONLY public.detailsachat ALTER COLUMN id_produit SET DEFAULT nextval('public.detailsachat_id_produit_seq'::regclass);
 F   ALTER TABLE public.detailsachat ALTER COLUMN id_produit DROP DEFAULT;
       public          postgres    false    228    225            �           2604    16674    detailsachat id_achat    DEFAULT     ~   ALTER TABLE ONLY public.detailsachat ALTER COLUMN id_achat SET DEFAULT nextval('public.detailsachat_id_achat_seq'::regclass);
 D   ALTER TABLE public.detailsachat ALTER COLUMN id_achat DROP DEFAULT;
       public          postgres    false    226    225            �           2604    16675    facturs id_facture    DEFAULT     x   ALTER TABLE ONLY public.facturs ALTER COLUMN id_facture SET DEFAULT nextval('public.facturs_id_facture_seq'::regclass);
 A   ALTER TABLE public.facturs ALTER COLUMN id_facture DROP DEFAULT;
       public          postgres    false    230    229            �           2604    16676    fournisseur nf    DEFAULT     r   ALTER TABLE ONLY public.fournisseur ALTER COLUMN nf SET DEFAULT nextval('public."fournisseur_NF_seq"'::regclass);
 =   ALTER TABLE public.fournisseur ALTER COLUMN nf DROP DEFAULT;
       public          postgres    false    232    231            �           2604    16677 	   login idu    DEFAULT     f   ALTER TABLE ONLY public.login ALTER COLUMN idu SET DEFAULT nextval('public.login_idu_seq'::regclass);
 8   ALTER TABLE public.login ALTER COLUMN idu DROP DEFAULT;
       public          postgres    false    234    233            �           2604    16678    produit id_mt    DEFAULT     o   ALTER TABLE ONLY public.produit ALTER COLUMN id_mt SET DEFAULT nextval('public."matierep_NMP_seq"'::regclass);
 <   ALTER TABLE public.produit ALTER COLUMN id_mt DROP DEFAULT;
       public          postgres    false    236    235            �           2604    16679    servise id_ser    DEFAULT     p   ALTER TABLE ONLY public.servise ALTER COLUMN id_ser SET DEFAULT nextval('public.servise_id_ser_seq'::regclass);
 =   ALTER TABLE public.servise ALTER COLUMN id_ser DROP DEFAULT;
       public          postgres    false    238    237            T          0    16602    achat 
   TABLE DATA           W   COPY public.achat (id_achat, id_fournisser, houreachat, totale, dateachat) FROM stdin;
    public          postgres    false    214   �w       W          0    16609    bonr 
   TABLE DATA           ^   COPY public.bonr ("NBR", quntite, datea, prixuntaire, prixtotal, designtion, nom) FROM stdin;
    public          postgres    false    217   �x       Y          0    16615    client 
   TABLE DATA           a   COPY public.client (nc, nom, mobile, email, adrasse, nrc, ai, aif, nis, tin, remise) FROM stdin;
    public          postgres    false    219   ;y       [          0    16621    deatilsfactures 
   TABLE DATA           �   COPY public.deatilsfactures (id_datailsfacture, id_facture, id_produit, quntite, prixvente, montant, totale, "user", produit) FROM stdin;
    public          postgres    false    221   �z       _          0    16629    detailsachat 
   TABLE DATA           g   COPY public.detailsachat (id_detailsachat, id_produit, id_achat, prixacaht, qnte, montant) FROM stdin;
    public          postgres    false    225   L}       c          0    16635    facturs 
   TABLE DATA           U   COPY public.facturs (id_facture, datefacture, heuer, id_client, montant) FROM stdin;
    public          postgres    false    229   �}       e          0    16641    fournisseur 
   TABLE DATA           ^   COPY public.fournisseur (nf, nom, mobile, email, adrasse, nrc, ai, aif, nis, tin) FROM stdin;
    public          postgres    false    231   ր       g          0    16647    login 
   TABLE DATA           5   COPY public.login (idu, nom, pass, type) FROM stdin;
    public          postgres    false    233   |�       i          0    16653    produit 
   TABLE DATA           N   COPY public.produit (id_mt, disgnation, prixvent, prixachat, qnt) FROM stdin;
    public          postgres    false    235   ρ       k          0    16659    servise 
   TABLE DATA           5   COPY public.servise (id_ser, nom, prixs) FROM stdin;
    public          postgres    false    237   ��       �           0    0    achat_id_achat_seq    SEQUENCE SET     A   SELECT pg_catalog.setval('public.achat_id_achat_seq', 31, true);
          public          postgres    false    215            �           0    0    achat_id_cleint_seq    SEQUENCE SET     B   SELECT pg_catalog.setval('public.achat_id_cleint_seq', 1, false);
          public          postgres    false    216            �           0    0    bonr_NBR_seq    SEQUENCE SET     =   SELECT pg_catalog.setval('public."bonr_NBR_seq"', 19, true);
          public          postgres    false    218            �           0    0    client_nc_seq    SEQUENCE SET     <   SELECT pg_catalog.setval('public.client_nc_seq', 56, true);
          public          postgres    false    220            �           0    0 $   deatilsfacures_id_datailsfacture_seq    SEQUENCE SET     T   SELECT pg_catalog.setval('public.deatilsfacures_id_datailsfacture_seq', 109, true);
          public          postgres    false    222            �           0    0    deatilsfacures_id_facture_seq    SEQUENCE SET     L   SELECT pg_catalog.setval('public.deatilsfacures_id_facture_seq', 1, false);
          public          postgres    false    223            �           0    0    deatilsfacures_id_produit_seq    SEQUENCE SET     L   SELECT pg_catalog.setval('public.deatilsfacures_id_produit_seq', 1, false);
          public          postgres    false    224            �           0    0    detailsachat_id_achat_seq    SEQUENCE SET     H   SELECT pg_catalog.setval('public.detailsachat_id_achat_seq', 1, false);
          public          postgres    false    226            �           0    0     detailsachat_id_detailsachat_seq    SEQUENCE SET     O   SELECT pg_catalog.setval('public.detailsachat_id_detailsachat_seq', 29, true);
          public          postgres    false    227            �           0    0    detailsachat_id_produit_seq    SEQUENCE SET     J   SELECT pg_catalog.setval('public.detailsachat_id_produit_seq', 1, false);
          public          postgres    false    228            �           0    0    facturs_id_facture_seq    SEQUENCE SET     F   SELECT pg_catalog.setval('public.facturs_id_facture_seq', 107, true);
          public          postgres    false    230            �           0    0    fournisseur_NF_seq    SEQUENCE SET     C   SELECT pg_catalog.setval('public."fournisseur_NF_seq"', 12, true);
          public          postgres    false    232            �           0    0    login_idu_seq    SEQUENCE SET     ;   SELECT pg_catalog.setval('public.login_idu_seq', 4, true);
          public          postgres    false    234            �           0    0    matierep_NMP_seq    SEQUENCE SET     A   SELECT pg_catalog.setval('public."matierep_NMP_seq"', 29, true);
          public          postgres    false    236            �           0    0    servise_id_ser_seq    SEQUENCE SET     A   SELECT pg_catalog.setval('public.servise_id_ser_seq', 14, true);
          public          postgres    false    238            �           2606    16681    achat achat_pkey 
   CONSTRAINT     g   ALTER TABLE ONLY public.achat
    ADD CONSTRAINT achat_pkey PRIMARY KEY (id_achat) INCLUDE (id_achat);
 :   ALTER TABLE ONLY public.achat DROP CONSTRAINT achat_pkey;
       public            postgres    false    214            �           2606    16683    bonr bonr_pkey 
   CONSTRAINT     O   ALTER TABLE ONLY public.bonr
    ADD CONSTRAINT bonr_pkey PRIMARY KEY ("NBR");
 8   ALTER TABLE ONLY public.bonr DROP CONSTRAINT bonr_pkey;
       public            postgres    false    217            �           2606    16685    client client_pkey 
   CONSTRAINT     P   ALTER TABLE ONLY public.client
    ADD CONSTRAINT client_pkey PRIMARY KEY (nc);
 <   ALTER TABLE ONLY public.client DROP CONSTRAINT client_pkey;
       public            postgres    false    219            �           2606    16687 $   deatilsfactures deatilsfactures_pkey 
   CONSTRAINT     �   ALTER TABLE ONLY public.deatilsfactures
    ADD CONSTRAINT deatilsfactures_pkey PRIMARY KEY (id_datailsfacture) INCLUDE (id_datailsfacture);
 N   ALTER TABLE ONLY public.deatilsfactures DROP CONSTRAINT deatilsfactures_pkey;
       public            postgres    false    221            �           2606    16689    detailsachat detailsachat_pkey 
   CONSTRAINT     i   ALTER TABLE ONLY public.detailsachat
    ADD CONSTRAINT detailsachat_pkey PRIMARY KEY (id_detailsachat);
 H   ALTER TABLE ONLY public.detailsachat DROP CONSTRAINT detailsachat_pkey;
       public            postgres    false    225            �           2606    16691    facturs facturs_pkey 
   CONSTRAINT     Z   ALTER TABLE ONLY public.facturs
    ADD CONSTRAINT facturs_pkey PRIMARY KEY (id_facture);
 >   ALTER TABLE ONLY public.facturs DROP CONSTRAINT facturs_pkey;
       public            postgres    false    229            �           2606    16693    fournisseur fournisseur_pkey 
   CONSTRAINT     Z   ALTER TABLE ONLY public.fournisseur
    ADD CONSTRAINT fournisseur_pkey PRIMARY KEY (nf);
 F   ALTER TABLE ONLY public.fournisseur DROP CONSTRAINT fournisseur_pkey;
       public            postgres    false    231            �           2606    16695    login login_pkey 
   CONSTRAINT     O   ALTER TABLE ONLY public.login
    ADD CONSTRAINT login_pkey PRIMARY KEY (idu);
 :   ALTER TABLE ONLY public.login DROP CONSTRAINT login_pkey;
       public            postgres    false    233            �           2606    16697    produit matierep_pkey 
   CONSTRAINT     V   ALTER TABLE ONLY public.produit
    ADD CONSTRAINT matierep_pkey PRIMARY KEY (id_mt);
 ?   ALTER TABLE ONLY public.produit DROP CONSTRAINT matierep_pkey;
       public            postgres    false    235            �           2606    16699    servise servise_pkey 
   CONSTRAINT     V   ALTER TABLE ONLY public.servise
    ADD CONSTRAINT servise_pkey PRIMARY KEY (id_ser);
 >   ALTER TABLE ONLY public.servise DROP CONSTRAINT servise_pkey;
       public            postgres    false    237            �           1259    16700    bnfn    INDEX     6   CREATE INDEX bnfn ON public.bonr USING btree ("NBR");
    DROP INDEX public.bnfn;
       public            postgres    false    217            �           1259    16701    clientfacture    INDEX     F   CREATE INDEX clientfacture ON public.facturs USING btree (id_client);
 !   DROP INDEX public.clientfacture;
       public            postgres    false    229            �           1259    16702    details_produit    INDEX     N   CREATE INDEX details_produit ON public.detailsachat USING btree (id_produit);
 #   DROP INDEX public.details_produit;
       public            postgres    false    225            �           1259    16703 
   dtailschat    INDEX     G   CREATE INDEX dtailschat ON public.detailsachat USING btree (id_achat);
    DROP INDEX public.dtailschat;
       public            postgres    false    225            �           1259    16704    fki_achtfournniseur    INDEX     N   CREATE INDEX fki_achtfournniseur ON public.achat USING btree (id_fournisser);
 '   DROP INDEX public.fki_achtfournniseur;
       public            postgres    false    214            �           1259    16705    fki_c    INDEX     G   CREATE INDEX fki_c ON public.deatilsfactures USING btree (id_produit);
    DROP INDEX public.fki_c;
       public            postgres    false    221            �           1259    16706 	   fki_dtfct    INDEX     K   CREATE INDEX fki_dtfct ON public.deatilsfactures USING btree (id_facture);
    DROP INDEX public.fki_dtfct;
       public            postgres    false    221            �           2606    16707    achat achtfournniseur    FK CONSTRAINT     �   ALTER TABLE ONLY public.achat
    ADD CONSTRAINT achtfournniseur FOREIGN KEY (id_fournisser) REFERENCES public.fournisseur(nf) NOT VALID;
 ?   ALTER TABLE ONLY public.achat DROP CONSTRAINT achtfournniseur;
       public          postgres    false    231    214    3258            �           2606    16712 '   detailsachat detailsachat_id_achat_fkey    FK CONSTRAINT     �   ALTER TABLE ONLY public.detailsachat
    ADD CONSTRAINT detailsachat_id_achat_fkey FOREIGN KEY (id_achat) REFERENCES public.achat(id_achat) ON UPDATE SET NULL NOT VALID;
 Q   ALTER TABLE ONLY public.detailsachat DROP CONSTRAINT detailsachat_id_achat_fkey;
       public          postgres    false    214    225    3239            �           2606    16717 )   detailsachat detailsachat_id_produit_fkey    FK CONSTRAINT     �   ALTER TABLE ONLY public.detailsachat
    ADD CONSTRAINT detailsachat_id_produit_fkey FOREIGN KEY (id_produit) REFERENCES public.produit(id_mt) NOT VALID;
 S   ALTER TABLE ONLY public.detailsachat DROP CONSTRAINT detailsachat_id_produit_fkey;
       public          postgres    false    225    235    3262            �           2606    16722    deatilsfactures dtailsproduit    FK CONSTRAINT     �   ALTER TABLE ONLY public.deatilsfactures
    ADD CONSTRAINT dtailsproduit FOREIGN KEY (id_produit) REFERENCES public.produit(id_mt) NOT VALID;
 G   ALTER TABLE ONLY public.deatilsfactures DROP CONSTRAINT dtailsproduit;
       public          postgres    false    3262    235    221            �           2606    16727    facturs facturs_id_Client_fkey    FK CONSTRAINT     �   ALTER TABLE ONLY public.facturs
    ADD CONSTRAINT "facturs_id_Client_fkey" FOREIGN KEY (id_client) REFERENCES public.client(nc) NOT VALID;
 J   ALTER TABLE ONLY public.facturs DROP CONSTRAINT "facturs_id_Client_fkey";
       public          postgres    false    219    229    3245            T   �   x�}�[�0D��d+H��N��Z��uH�"��>ٺP{Ҟe#�h`B�lR�(*�6Tve��]Ǝ��L��>>,BD���հ��L�N�e�Xz�E��fVV���Ľ�����v�CJq�&g���t�����Oը.Ԍړ�|�O�� -�|�>Y`��� /tը��B>���'���`��      W   }   x����1߸[,`c7�
��:��rw�|#�fV ���*�ZU'g/V11ljNT]E[ό9gR[;���@�郫�o��Ņ�?D��ON�ݧ�=}��꽫���k�_�9tę^���VJy�6�      Y   �  x��Q�n�0}�"?�(񝷒R��*�Bii_�c 	/�6_�����Z[����)}2ըﺻW�a2-�0TL
�u����<��/5RhM��N:�j&U~��B:�V��jk��0JF(\�i�����K�k c����Y���qF�]�X�Y��\i.��HbJ${�������$�����~u�V �b�����}��w(9��
�����V9�J��V��+ض�F�S�!�0�:�ݤF��6���颛k!eث���%\���K6�%l		8����%������+qHߞ���r!߀���O+����2��,�
�L��H���q�H��YJ)����HKJ�\�1*�YZpb�i��H�
������י�X@QI!�龔%yVԧyV�	�QQ�K��i�FE���������:��;<¥      [   B  x���a�d!����K�	����B{6:�`;�tҟX"q!f��B_��~����	H;�3��ߐ��(�Bek��F�l�:�j��Q���*d��S�������
�'����}���Ǣ���ok:���vR��7-�d�Գ��8�0Ib��ʈb/-�p!>F��0d�qyQ�x}S�7#�s�}�yר��3`��坡~���ЀM�=���C�yE��JA5�βn�z�*�8ތ�:I��?*��4���I�'\���q�63.�%㕔3�H%�JZ3n���I3�t�f�a�h���?c��?�C�}����5�ǉ|��Eo!�c�:B�m��^-g>l���i���(=qߣ��+�v�4>y?��~�)l���6	�dMu�!�١ҋ�x��w����a�܏�?���ث1�9[�ɾ�Ү�ܕ Ě��J��+����#���頮Q�� ���zs&������OlY��qE֔6gU�x��ҡn�-�N�sN���-|+ϲ�y����=�'ӈ������F�}��ԄY�z�F�f��G9������.�;\���:�K��d+�Wlu�O�*�����<���+      _   �   x�m�A� C�u8̈8ڻ����;KH��>��y�2G����_��a_��!/���\�����<��efi[=�Ǭ�x#G�*\�A܊����x��(��4b*��p�>SEA��"hX-��E`�,��E�"�(�,
-�~c�?e�P�      c   �  x���[��*E�+��	�~�a,w��6I[}��(i�8�0�����S��e�~�?X��0
��CyCb�}��7d{XNX����蘍j�<Pn����ॡ�����^��wu��Qڠ54��>P�萾0܇���$؅�c��D��V�,���:����}���ۥnr,	'x8����c���>���ͥ޸����YW�[����X���ɧ�tx�*����m���+a�y���+�c	�=Ń6�m����Y�ri��o��x�98x���Q�nK�A��Q�c��نw/9/o�c�Ȱm�sQ`΍%�asj�-в��
���/)Y�� d�����Ѥ�HM�HM�-���m-$3��L¶X53I� �f�*��g��TØ`�sԣR��vo�ʁ��;'���U�$p�s ��IBf	��*�Q�;�f���ZM8�z��C�i��i�6M-Xt���,�:1�w}I�f�����z���U��_���1G���Wj�]�>o�o�r��W���DW����N��������~������,9�K��*�נ�����o���`������y�k�g׷�v`����`O���/y�q�{v��ows���.��k�y��gh��p���1vqθ>2��Y[��3sP�����(A�������|�ۗ��ۡ����8��?8/      e   �   x���A
�0Dד�H5�?u�E�h7�|��h�)����7h����v�Zk?$8�4$}��3�Kը[Fh�m��Ue��ֿ�2�y-�B�1���#HO�����#4�si��7Sc�4G�=�(���>š����S'�$Q�����	$��      g   C   x�3�LLJI-*J�J��4426�tL����2��/�I2S�¦f�����9���\&Xe!:c���� d�R      i   �   x�e��
�@E�;_�Pvf�)�,D���n �B-��n"Xāi.g���bߍ��
��{�NSfc�1!Aˈ��������)��lsmHr�s�$ڤǹ&��:K��-�#	�ې�i��6�=vž*�_�QČ�h��Usj2���Z�l��\r1�      k   �   x�m�9�0D��)|d�1Ki��`ɉ-'����H����'�yz��j<�N����p����p��Y��1Qۺ�p�`%�dC�C�Q%��>qoZJ*�%bh���6xo�Z�B6\����l�ˢ7�j��L6���.��Q��~�����=���љ�?�a�{cY:4     