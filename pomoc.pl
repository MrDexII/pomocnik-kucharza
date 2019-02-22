
przeszukaj([Head|Tail1], [Head|Tail]).
przeszukaj([Head1|Tail1], [Head|Tail]):- przeszukaj([Head1], Tail);
                                            przeszukaj(Tail1, [Head|Tail]).

pomoc(SkladnikiJakieMamy,Przepis,Danie, Link):- potrawa(Przepis, Danie, Link),
                                          przeszukaj(SkladnikiJakieMamy, Przepis).


potrawa([mieso_wolowe,
         musztarda,
         wedzony_boczek,
         czerwona_cebula,
         kiszone_ogorki,
         chleb],
         zrazy_z_razowym_chlebem,
         "http://tiny.pl/gl2sb").

potrawa([liscie_laurowe,
         cebula,
         jablko,
         ziele_angielskie,
         czosnek,
         chleb],
         wegetarianski_smalec,
         "http://tiny.pl/gl2sv").

potrawa([maka_pszenna,
         woda,
         ziemniaki,
         twarog,
         cebula,
         maslo,
         sol,
         pieprz],
         pierogi_ruskie,
         "http://tiny.pl/glkv7").

potrawa([mieso_wolowe,
         mieso_drobiowe,
         marchewka,
         pietruszka,
         por,
         cebula,
         lisc_laurowy,
         ziele_angielskie,
         pieprz,
         sol],
         rosol,
         "http://tiny.pl/glkv2").

potrawa([maka_pszenna,
         jajko,
         mleko,
         woda,
         sol,
         olej_roslinny],
         nalesniki,
         "http://tiny.pl/glkvz").

potrawa([por,
         cebula,
         maslo,
         bulion,
         szynka,
         serek_topiony,
         smietana,
         sol,
         pieprz,
         galka_muszkatalowa,
         ser_zolty,
         natka_pietruszki],
         dunska_zupa_z_porow,
         "http://tiny.pl/glkbt").

potrawa([mleko,
         maslo,
         cukier,
         sol,
         drozdze,
         jajka,
         maka_pszenna],
         rogale_maslane,
         "http://tiny.pl/glkb1").

potrawa([kurki,
         cebula,
         bulion,
         ziemniaki,
         makaron_drobny,
         olej,
         maslo,
         smietana,
         sol,
         pieprz,
         natka_pietruszki],
         zupa_z_kurek,
         "http://tiny.pl/glkbz").

potrawa([kasza_jeczmienna,
         woda,
         marchewka,
         pietruszka,
         seler,
         por,
         mieso_drobiowe,
         cebula,
         czosnek,
         ziemniaki,
         grzyby,
         lisc_laurowy,
         ziele_angielskie,
         pieprz,
         natka_pietruszki,
         maslo,
         sol,
         pieprz],
         krupnik,
         "http://tiny.pl/glkzc").

potrawa([maslo,
         oliwa,
         cebula,
         marchewka,
         bulion,
         ziemniaki,
         kiszone_ogorki,
         smietana,
         szczypiorek],
         zupa_ogorkowa,
         "http://tiny.pl/glkzl").

potrawa([maslo,
         oliwa,
         cebula,
         marchewka,
         bulion,
         ziemniaki,
         brukselka,
         smietana,
         szczypiorek],
         zupa_z_brukselki,
         "http://tiny.pl/glkz2").

potrawa([ziemniaki,
         sol,
         pieprz,
         jajka,
         natka_pietruszki,
         olej,
         bulka_tarta],
         krokiety_ziemniaczane,
         "http://tiny.pl/glkzb").

potrawa([cukinia,
         czosnek,
         jajka,
         mleko,
         bulka_tarta,
         sol,
         pieprz,
         oregano,
         tymianek,
         oliwa],
         frytki_z_cukinni,
         "http://tiny.pl/glk3g").

potrawa([boczek,
         cebula,
         seler_naciowy,
         marchewka,
         oliwa,
         mieso_wieprzowe,
         czerwone_wino,
         bulion,
         koncentrat_pomidorowy,
         pomidory,
         mleko,
         makaron,
         parmezan],
         spaghetti_bolognese,
         "http://tiny.pl/glk3c").

potrawa([makaronu,
         cebula,
         czosnek,
         oliwa,
         maslo,
         szpinak,
         smietana,
         parmezan],
         makaron_ze_szpinakiem,
         "http://tiny.pl/glk3j").

potrawa([kalafior,
         kasza_jaglana,
         bulion,
         jajko,
         natka_pietruszki,
         bulka_tarta,
         galka_muszkatalowa,
         pieprz],
         krokiety_z_kalafiora,
         "http://tiny.pl/glk3l").

potrawa([botwinka,
         bulion,
         kefir,
         smietana,
         szczypiorek,
         koperek,
         ogorki,
         czosnek,
         ocet],
         chlodnik_litewski,
         "http://tiny.pl/glk36").

potrawa([maslo,
         czekolada,
         deserowa,
         mleko,
         jajka,
         cukier,
         maka_pszenna,
         proszek_do_pieczenia],
         ciasto_czekoladowe,
         "http://tiny.pl/glk3z").

potrawa([ziemniaki,
         maka_pszenna,
         cebula,
         jajko,
         sol,
         olej],
         placki_ziemniaczane,
         "http://tiny.pl/gl2hs").

potrawa([fasola,
         liscie_laurowe,
         ziele_angielskie,
         kielbasa,
         boczek,
         olej,
         cebula,
         pomidory,
         majeranek,
         czosnkek,
         sol,
         pieprz,
         maka_pszenna,
         maslo],
         fasolka_po_bretonsku,
         "http://tiny.pl/gl2qm").

potrawa([pomidory,
         papryka,
         dynia,
         seler,
         pietruszka,
         cebula,
         por,
         marchewka,
         cukinia,
         ziemniaki,
         kapusta,
         liscie_laurowe,
         czosnek,
         biala_fasola,
         zielona_fasolka,
         bulion,
         natka_pietruszki,
         makaron,
         oliwa],
         minestrone,
         "http://tiny.pl/gl288").

potrawa([mieso_drobiowe,
         pieprz,
         szynka,
         pomidory_z_puszki,
         oregano,
         cukier,
         oliwa,
         maslo,
         bazylia],
         kurczak_w_pomidorach,
         "http://tiny.pl/gl2ss").

% szukamy konkretnego przepisu
% np.
% pomoc([_], X, wegetarianski_smalec, Y).

% wpisujemy składniki i otrzymujemy nazwe przepisu
%np.
% pomoc([mieso_wolowe], X, Y, Z).
% pomoc([chleb], X, Y, Z).



