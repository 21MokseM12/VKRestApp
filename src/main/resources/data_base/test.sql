PGDMP  3    #                |            restApiDataBase    16.0    16.0     �           0    0    ENCODING    ENCODING        SET client_encoding = 'UTF8';
                      false            �           0    0 
   STDSTRINGS 
   STDSTRINGS     (   SET standard_conforming_strings = 'on';
                      false            �           0    0 
   SEARCHPATH 
   SEARCHPATH     8   SELECT pg_catalog.set_config('search_path', '', false);
                      false            �           1262    16682    restApiDataBase    DATABASE     �   CREATE DATABASE "restApiDataBase" WITH TEMPLATE = template0 ENCODING = 'UTF8' LOCALE_PROVIDER = libc LOCALE = 'Russian_Russia.1251';
 !   DROP DATABASE "restApiDataBase";
                postgres    false            �            1259    16698    clients    TABLE     �   CREATE TABLE public.clients (
    id integer NOT NULL,
    role character varying(20) NOT NULL,
    login character varying(200) NOT NULL,
    password character varying(254) NOT NULL,
    token character varying(20) NOT NULL
);
    DROP TABLE public.clients;
       public         heap    postgres    false            �            1259    16697    clients_id_seq    SEQUENCE     �   CREATE SEQUENCE public.clients_id_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
 %   DROP SEQUENCE public.clients_id_seq;
       public          postgres    false    216            �           0    0    clients_id_seq    SEQUENCE OWNED BY     A   ALTER SEQUENCE public.clients_id_seq OWNED BY public.clients.id;
          public          postgres    false    215                       2604    16701 
   clients id    DEFAULT     h   ALTER TABLE ONLY public.clients ALTER COLUMN id SET DEFAULT nextval('public.clients_id_seq'::regclass);
 9   ALTER TABLE public.clients ALTER COLUMN id DROP DEFAULT;
       public          postgres    false    215    216    216            �          0    16698    clients 
   TABLE DATA           C   COPY public.clients (id, role, login, password, token) FROM stdin;
    public          postgres    false    216   �
       �           0    0    clients_id_seq    SEQUENCE SET     =   SELECT pg_catalog.setval('public.clients_id_seq', 10, true);
          public          postgres    false    215                       2606    16703    clients clients_pkey 
   CONSTRAINT     R   ALTER TABLE ONLY public.clients
    ADD CONSTRAINT clients_pkey PRIMARY KEY (id);
 >   ALTER TABLE ONLY public.clients DROP CONSTRAINT clients_pkey;
       public            postgres    false    216            �      x������ � �     