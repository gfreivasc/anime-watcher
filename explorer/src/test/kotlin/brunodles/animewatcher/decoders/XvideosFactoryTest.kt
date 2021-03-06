package brunodles.animewatcher.decoders

import brunodles.animewatcher.explorer.Episode
import brunodles.animewatcher.testhelper.FactoryChecker
import brunodles.animewatcher.testhelper.FactoryChecker.whenCheckIsEpisode
import brunodles.animewatcher.testhelper.FactoryChecker.whenEpisode
import brunodles.urlfetcher.UrlFetcher
import com.greghaskins.spectrum.Spectrum
import com.greghaskins.spectrum.Spectrum.xit
import org.junit.runner.RunWith

@RunWith(Spectrum::class)
class XvideosFactoryTest {

    private companion object {
        val VALID_URLS = arrayOf(
            "https://www.xvideos.com/video12026193/anita_troca_o_peluche_pelo_pau",
            "http://www.xvideos.com/video12026193/anita_troca_o_peluche_pelo_pau",
            "xvideos.com/video12026193/anita_troca_o_peluche_pelo_pau"
        )
        val INVALID_URLS = emptyArray<String>()
        val currentEpisode = Episode(
            number = 1,
            description = "Anita Troca O Peluche Pelo Pau",
            animeName = "Anita Troca O Peluche Pelo Pau",
            image = null,
            link = "https://www.xvideos.com/video12026193/anita_troca_o_peluche_pelo_pau",
            video = "https://vid-egc.xvideos-cdn.com/videos/mp4/3/b/8/xvideos.com_3b868ff7bff12466c8ea1fe7b79623ca-1.mp4?ZO04uwlt2FLlkz8q7Xyxk7L6_5H_XrEOh1fTX2L7t8iODJ0VEevLufUG9nVmjU-6_X-c5Rg9CxT_LzX9_tzrKHm5w3p_T211XVW33AgtbuAY1As4iMkSqlGAr-rsXp1gzAR2Ax0FAtar08Ey7tlGaZ7RHt7LbUE6Fl4qVQho93lcNuGBzk-3YUZJiXHRb2_JRS3f0mcITeeRbw",
            nextEpisodes = arrayListOf(
                Episode(
                    number = 2,
                    animeName = "Anal Secretary FULL SCENE PORNTUGAL.COM",
                    image = "https://img-egc.xvideos-cdn.com/videos/thumbs169/a3/26/8f/a3268f3728da2474fd1eb567b6d9f8af/a3268f3728da2474fd1eb567b6d9f8af.2.jpg",
                    description = "35 min",
                    link = "http://xvideos.com/video28716451/anal_secretary_full_scene_porntugal.com"
                ),
                Episode(
                    number = 3,
                    animeName = "Rebecca Levada Ao Tapete",
                    image = "https://img-hw.xvideos-cdn.com/videos/thumbs169/95/08/49/9508497604830764fd7d020524470b4d/9508497604830764fd7d020524470b4d.29.jpg",
                    description = "9 min",
                    link = "http://xvideos.com/video12028307/rebecca_levada_ao_tapete"
                ),
                Episode(
                    number = 4,
                    animeName = "Esposa Tamanho XXL / Extra Sized Wife",
                    image = "https://img-egc.xvideos-cdn.com/videos/thumbs169/eb/a4/d3/eba4d3b14e9e3309a0f1004d4019a5bb/eba4d3b14e9e3309a0f1004d4019a5bb.30.jpg",
                    description = "20 min",
                    link = "http://xvideos.com/video19331203/esposa_tamanho_xxl_extra_sized_wife"
                ),
                Episode(
                    number = 5,
                    animeName = "Anita Aprende A Mamar",
                    image = "https://img-egc.xvideos-cdn.com/videos/thumbs169/e3/a4/fb/e3a4fb75444e7123d21665c0edc60d90/e3a4fb75444e7123d21665c0edc60d90.8.jpg",
                    description = "9 min",
                    link = "http://xvideos.com/video11970655/anita_aprende_a_mamar"
                ),
                Episode(
                    number = 6,
                    animeName = "Rep&oacute;rter Trocou o Microfone Pelo Pau",
                    image = "https://img-egc.xvideos-cdn.com/videos/thumbs169/f4/0d/8b/f40d8b03e5f7325da2d9bbb56c89d35e/f40d8b03e5f7325da2d9bbb56c89d35e.7.jpg",
                    description = "1 min 0 sec",
                    link = "http://xvideos.com/video3759181/reporter_trocou_o_microfone_pelo_pau"
                ),
                Episode(
                    number = 7,
                    animeName = "As Ronaldas - Trailer",
                    image = "https://images-llnw.xvideos-cdn.com/videos/thumbs169/ad/06/15/ad0615773a0b434b9c315afc80e95843/ad0615773a0b434b9c315afc80e95843.18.jpg",
                    description = "2 min",
                    link = "http://xvideos.com/video22312749/as_ronaldas_-_trailer"
                ),
                Episode(
                    number = 8,
                    animeName = "Foda Milagrosa - Trailer",
                    image = "https://img-egc.xvideos-cdn.com/videos/thumbs169/b7/84/e4/b784e49d5ce0cb41e4dee6826b66d831/b784e49d5ce0cb41e4dee6826b66d831.17.jpg",
                    description = "45 sec",
                    link = "http://xvideos.com/video27469105/foda_milagrosa_-_trailer"
                ),
                Episode(
                    number = 9,
                    animeName = "A Real Slut In Real Estate",
                    image = "https://img-egc.xvideos-cdn.com/videos/thumbs169/40/4a/72/404a7276766fc9256d81090c97cac919/404a7276766fc9256d81090c97cac919.5.jpg",
                    description = "13 min",
                    link = "http://xvideos.com/video32232811/a_real_slut_in_real_estate"
                ),
                Episode(
                    number = 10,
                    animeName = "Flagrou irm&atilde; dando mole e fodeu a gata gostosa",
                    image = "https://img-l3.xvideos-cdn.com/videos/thumbs169/af/ad/4e/afad4efafed6cb12f080a3a3c21db784/afad4efafed6cb12f080a3a3c21db784.5.jpg",
                    description = "8 min",
                    link = "http://xvideos.com/video22219823/flagrou_irma_dando_mole_e_fodeu_a_gata_gostosa"
                ),
                Episode(
                    number = 11,
                    animeName = "Anal A Moda Do Porto / Anal Oporto Style",
                    image = "https://images-llnw.xvideos-cdn.com/videos/thumbs169/7a/1a/3e/7a1a3ebf332cc322e2d6045bae240c3d/7a1a3ebf332cc322e2d6045bae240c3d.18.jpg",
                    description = "14 min",
                    link = "http://xvideos.com/video20069673/anal_a_moda_do_porto_anal_oporto_style"
                ),
                Episode(
                    number = 12,
                    animeName = "Comendo a irm&atilde; gostosa do amigo",
                    image = "https://img-egc.xvideos-cdn.com/videos/thumbs169/8c/3c/c3/8c3cc311c5e6b86ef1ed7893b752abe9/8c3cc311c5e6b86ef1ed7893b752abe9.2.jpg",
                    description = "9 min",
                    link = "http://xvideos.com/video29099393/comendo_a_irma_gostosa_do_amigo"
                ),
                Episode(
                    number = 13,
                    animeName = "Anita Apanhada Por Tr&aacute;s",
                    image = "https://img-hw.xvideos-cdn.com/videos/thumbs169/a8/d2/86/a8d286f324fcd8889f2cd54fa120e778/a8d286f324fcd8889f2cd54fa120e778.2.jpg",
                    description = "16 min",
                    link = "http://xvideos.com/video11867345/anita_apanhada_por_tras"
                ),
                Episode(
                    number = 14,
                    animeName = "Aline Drained My Balls",
                    image = "https://images-llnw.xvideos-cdn.com/videos/thumbs169/dd/ca/4b/ddca4b7be2065f0d05791826f1a50500/ddca4b7be2065f0d05791826f1a50500.21.jpg",
                    description = "2 min",
                    link = "http://xvideos.com/video16235657/aline_drained_my_balls"
                ),
                Episode(
                    number = 15,
                    animeName = "legendarios Juju Salimeni vira modelo vivo e fica completamente nua 15 06 2013 mircmirc",
                    image = "https://img-egc.xvideos-cdn.com/videos/thumbs169/6a/5f/f0/6a5ff0eb540fd698468bb81f6c2465db/6a5ff0eb540fd698468bb81f6c2465db.29.jpg",
                    description = "15 min",
                    link = "http://xvideos.com/video4969454/legendarios_juju_salimeni_vira_modelo_vivo_e_fica_completamente_nua_15_06_2013_mircmirc"
                ),
                Episode(
                    number = 16,
                    animeName = "Travesti cavala - (Curte travestis? ACESSE: PISTOLUDAS.COM)",
                    image = "https://images-llnw.xvideos-cdn.com/videos/thumbs169/52/f6/14/52f614bd07101fce4b8c48ac746d9d28/52f614bd07101fce4b8c48ac746d9d28.5.jpg",
                    description = "6 min",
                    link = "http://xvideos.com/video29947755/travesti_cavala_-_curte_travestis_acesse_pistoludas.com_"
                ),
                Episode(
                    number = 17,
                    animeName = "Pegando a cunhada na frente da esposa",
                    image = "https://img-egc.xvideos-cdn.com/videos/thumbs169/21/5f/7b/215f7b3e2d70b84e39603fa3eb3fb7fd/215f7b3e2d70b84e39603fa3eb3fb7fd.12.jpg",
                    description = "3 min",
                    link = "http://xvideos.com/video25841191/pegando_a_cunhada_na_frente_da_esposa"
                ),
                Episode(
                    number = 18,
                    animeName = "Namorada novinha agradecendo a carona ao amigo (kasal top)",
                    image = "https://img-l3.xvideos-cdn.com/videos/thumbs169/e0/d7/94/e0d79460414a70e927a816dbbb51804e/e0d79460414a70e927a816dbbb51804e.5.jpg",
                    description = "3 min",
                    link = "http://xvideos.com/video33056819/namorada_novinha_agradecendo_a_carona_ao_amigo_kasal_top_"
                ),
                Episode(
                    number = 19,
                    animeName = "Latina frot&aacute;ndose con un peluche mientras ve porno",
                    image = "https://images-llnw.xvideos-cdn.com/videos/thumbs169/b4/33/c8/b433c85b9a49a46b5887d6c28992b841/b433c85b9a49a46b5887d6c28992b841.1.jpg",
                    description = "9 min",
                    link = "http://xvideos.com/video8767407/latina_frotandose_con_un_peluche_mientras_ve_porno"
                ),
                Episode(
                    number = 20,
                    animeName = "Rebecca Pinar Dominada e Penetrada",
                    image = "https://img-l3.xvideos-cdn.com/videos/thumbs169/e7/4b/c4/e74bc46a33b2bb3c330478a63c9b719f/e74bc46a33b2bb3c330478a63c9b719f.9.jpg",
                    description = "9 min",
                    link = "http://xvideos.com/video12372447/rebecca_pinar_dominada_e_penetrada"
                ),
                Episode(
                    number = 21,
                    animeName = "Puta Ao Ataque / Ronalda Wins The Game",
                    image = "https://images-llnw.xvideos-cdn.com/videos/thumbs169/e7/03/4f/e7034fe9c400ec8d40269014d358b717/e7034fe9c400ec8d40269014d358b717.30.jpg",
                    description = "10 min",
                    link = "http://xvideos.com/video22205341/puta_ao_ataque_ronalda_wins_the_game"
                ),
                Episode(
                    number = 22,
                    animeName = "Provoquei tanto o padrasto que ele me comeu",
                    image = "https://images-llnw.xvideos-cdn.com/videos/thumbs169/7d/fd/2c/7dfd2cf77688b787788f7e6ac735f781/7dfd2cf77688b787788f7e6ac735f781.16.jpg",
                    description = "13 min",
                    link = "http://xvideos.com/video34251341/provoquei_tanto_o_padrasto_que_ele_me_comeu"
                ),
                Episode(
                    number = 23,
                    animeName = "Estudante Porca Apanhada Pelo Professor / Naughty Schoolgirl Caught By The Teach",
                    image = "https://images-llnw.xvideos-cdn.com/videos/thumbs169/86/fa/c4/86fac41c810634c131bff63a1d5c232f/86fac41c810634c131bff63a1d5c232f.14.jpg",
                    description = "9 min",
                    link = "http://xvideos.com/video24087711/estudante_porca_apanhada_pelo_professor_naughty_schoolgirl_caught_by_the_teach"
                ),
                Episode(
                    number = 24,
                    animeName = "S&oacute;nia Kel Nascida Para Mamar",
                    image = "https://img-l3.xvideos-cdn.com/videos/thumbs169/19/d4/24/19d42461e2923f230fa7969361f73b44/19d42461e2923f230fa7969361f73b44.17.jpg",
                    description = "8 min",
                    link = "http://xvideos.com/video12029593/sonia_kel_nascida_para_mamar"
                ),
                Episode(
                    number = 25,
                    animeName = "Tia Dando Bem Gostoso Para Sobrinho",
                    image = "https://img-l3.xvideos-cdn.com/videos/thumbs169/dc/f9/72/dcf972b06aea23ef52b127091d973a47/dcf972b06aea23ef52b127091d973a47.9.jpg",
                    description = "13 min",
                    link = "http://xvideos.com/video26742527/tia_dando_bem_gostoso_para_sobrinho"
                ),
                Episode(
                    number = 26,
                    animeName = "Cuz&atilde;o da safada brithine",
                    image = "https://img-l3.xvideos-cdn.com/videos/thumbs169/1f/6b/66/1f6b66187013894e25c0c19eb4eeffba/1f6b66187013894e25c0c19eb4eeffba.1.jpg",
                    description = "6 min",
                    link = "http://xvideos.com/video28552303/cuzao_da_safada_brithine"
                ),
                Episode(
                    number = 27,
                    animeName = "Masturb&aacute;ndose con un pony de peluche",
                    image = "https://img-l3.xvideos-cdn.com/videos/thumbs169/96/04/8e/96048e8a948a47629b9549c4b842ed19/96048e8a948a47629b9549c4b842ed19.20.jpg",
                    description = "7 min",
                    link = "http://xvideos.com/video31320665/masturbandose_con_un_pony_de_peluche"
                ),
                Episode(
                    number = 28,
                    animeName = "Casa nova foda nova",
                    image = "https://img-egc.xvideos-cdn.com/videos/thumbs169/c9/3b/ad/c93bad3bbe17d2be2928aba7ff32fa2e/c93bad3bbe17d2be2928aba7ff32fa2e.6.jpg",
                    description = "19 min",
                    link = "http://xvideos.com/video9483582/casa_nova_foda_nova"
                ),
                Episode(
                    number = 29,
                    animeName = "S&oacute;nia Kel Ao Colinho Do Patr&atilde;o",
                    image = "https://img-egc.xvideos-cdn.com/videos/thumbs169/be/4d/2b/be4d2bf8d84a5cd45c85a24ff53550f2/be4d2bf8d84a5cd45c85a24ff53550f2.6.jpg",
                    description = "9 min",
                    link = "http://xvideos.com/video13533059/sonia_kel_ao_colinho_do_patrao"
                ),
                Episode(
                    number = 30,
                    animeName = "Lucia Encavada No Motel",
                    image = "https://images-llnw.xvideos-cdn.com/videos/thumbs169/ff/79/03/ff79035016cb8a6b6db9847dbd4346ca/ff79035016cb8a6b6db9847dbd4346ca.3.jpg",
                    description = "12 min",
                    link = "http://xvideos.com/video12140307/lucia_encavada_no_motel"
                ),
                Episode(
                    number = 31,
                    animeName = "Rebecca Pinar Foda De Meia Noite",
                    image = "https://img-egc.xvideos-cdn.com/videos/thumbs169/9c/60/0b/9c600bd94534fa5e780f505fa02676e2/9c600bd94534fa5e780f505fa02676e2.25.jpg",
                    description = "9 min",
                    link = "http://xvideos.com/video12133975/rebecca_pinar_foda_de_meia_noite"
                ),
                Episode(
                    number = 32,
                    animeName = "Trailer Tigresa Vip e o cuiabano morador de V&aacute;rzea Grande bairro Parque do Lago",
                    image = "https://images-llnw.xvideos-cdn.com/videos/thumbs169/3f/ef/0c/3fef0cc63a51778f0f780de246475721/3fef0cc63a51778f0f780de246475721.23.jpg",
                    description = "2 min",
                    link = "http://xvideos.com/video31919759/trailer_tigresa_vip_e_o_cuiabano_morador_de_varzea_grande_bairro_parque_do_lago"
                ),
                Episode(
                    number = 33,
                    animeName = "Moleque tarad&atilde;o socando a vara na m&atilde;e gostosa www.cadelanocio.com.br",
                    image = "https://images-llnw.xvideos-cdn.com/videos/thumbs169/73/c0/cd/73c0cdbb089c6dcaceb406ef921c7be7/73c0cdbb089c6dcaceb406ef921c7be7.7.jpg",
                    description = "26 min",
                    link = "http://xvideos.com/video28279045/moleque_taradao_socando_a_vara_na_mae_gostosa_www.cadelanocio.com.br"
                ),
                Episode(
                    number = 34,
                    animeName = "Scarlett Johnson Anita Leva Com Ele",
                    image = "https://images-llnw.xvideos-cdn.com/videos/thumbs169/c8/1d/2b/c81d2b8ca23f7a1d0552f31e0aa0120f/c81d2b8ca23f7a1d0552f31e0aa0120f.24.jpg",
                    description = "13 min",
                    link = "http://xvideos.com/video14609967/scarlett_johnson_anita_leva_com_ele"
                ),
                Episode(
                    number = 35,
                    animeName = "Rebecca Pinar Secret&aacute;ria Anal",
                    image = "https://img-hw.xvideos-cdn.com/videos/thumbs169/77/f0/a1/77f0a1473c8091712d6ab66baf9ba700/77f0a1473c8091712d6ab66baf9ba700.4.jpg",
                    description = "10 min",
                    link = "http://xvideos.com/video12030507/rebecca_pinar_secretaria_anal"
                ),
                Episode(
                    number = 36,
                    animeName = "Mujer montando en el peluche",
                    image = "https://img-egc.xvideos-cdn.com/videos/thumbs169/55/92/1b/55921bbc66cb0f64523c89f446d66927/55921bbc66cb0f64523c89f446d66927.17.jpg",
                    description = "29 sec",
                    link = "http://xvideos.com/video25746081/mujer_montando_en_el_peluche"
                ),
                Episode(
                    number = 37,
                    animeName = "Goleadoras Natas / Lick My Pussy And I Let You Score !",
                    image = "https://img-egc.xvideos-cdn.com/videos/thumbs169/9a/5c/a6/9a5ca65fd399e410072a87986a360991/9a5ca65fd399e410072a87986a360991.22.jpg",
                    description = "7 min",
                    link = "http://xvideos.com/video21890773/goleadoras_natas_lick_my_pussy_and_i_let_you_score_"
                ),
                Episode(
                    number = 38,
                    animeName = "Camila 19 anos buceta rosa caiu no Whats",
                    image = "https://images-llnw.xvideos-cdn.com/videos/thumbs169/50/56/04/505604691c3c736437b7ea4feeef7882/505604691c3c736437b7ea4feeef7882.5.jpg",
                    description = "3 min",
                    link = "http://xvideos.com/video19667401/camila_19_anos_buceta_rosa_caiu_no_whats"
                ),
                Episode(
                    number = 39,
                    animeName = "Safada chupando o pau do amante e conversando com o corno do namorado no telefone",
                    image = "https://img-egc.xvideos-cdn.com/videos/thumbs169/c6/fc/da/c6fcda11fdf1d54290d67fbf0fac5a7c/c6fcda11fdf1d54290d67fbf0fac5a7c.19.jpg",
                    description = "45 sec",
                    link = "http://xvideos.com/video10811475/safada_chupando_o_pau_do_amante_e_conversando_com_o_corno_do_namorado_no_telefone"
                ),
                Episode(
                    number = 40,
                    animeName = "Troca de Casais",
                    image = "https://images-llnw.xvideos-cdn.com/videos/thumbs169/f9/69/02/f969021fd655c0272fdf5a257af6e859/f969021fd655c0272fdf5a257af6e859.4.jpg",
                    description = "33 min",
                    link = "http://xvideos.com/video17226211/troca_de_casais"
                ),
                Episode(
                    number = 41,
                    animeName = "Filme Porno Atriz parecida com a Anitta",
                    image = "https://img-l3.xvideos-cdn.com/videos/thumbs169/49/37/60/493760f6d93bf7f34444041b1128a40d/493760f6d93bf7f34444041b1128a40d.7.jpg",
                    description = "9 min",
                    link = "http://xvideos.com/video33375263/filme_porno_atriz_parecida_com_a_anitta"
                ),
                Episode(
                    number = 42,
                    animeName = "Anita Vai &agrave; Prova Oral",
                    image = "https://images-llnw.xvideos-cdn.com/videos/thumbs169/52/9b/6c/529b6c1b17862c3c9d854efd0a27611f/529b6c1b17862c3c9d854efd0a27611f.28.jpg",
                    description = "10 min",
                    link = "http://xvideos.com/video11970181/anita_vai_a_prova_oral"
                ),
                Episode(
                    number = 43,
                    animeName = "Anita Estuda Para Ser Puta / Studying To Be a Slut",
                    image = "https://img-egc.xvideos-cdn.com/videos/thumbs169/6e/7a/ea/6e7aeac96fc65eb0b98b7172e90db148/6e7aeac96fc65eb0b98b7172e90db148.30.jpg",
                    description = "12 min",
                    link = "http://xvideos.com/video18634117/anita_estuda_para_ser_puta_studying_to_be_a_slut"
                ),
                Episode(
                    number = 44,
                    animeName = "S&oacute;nia Kel Trabalho Fodido",
                    image = "https://img-hw.xvideos-cdn.com/videos/thumbs169/a5/7f/11/a57f115fcda72b707e424d07cfca8fe2/a57f115fcda72b707e424d07cfca8fe2.7.jpg",
                    description = "7 min",
                    link = "http://xvideos.com/video12031513/sonia_kel_trabalho_fodido"
                ),
                Episode(
                    number = 45,
                    animeName = "858936 sexy thick ebony indian chick revenge strip ameman",
                    image = "https://img-l3.xvideos-cdn.com/videos/thumbs169/1a/38/54/1a3854b6d54ec6f48bb37bcfbbd209b9/1a3854b6d54ec6f48bb37bcfbbd209b9.5.jpg",
                    description = "5 min",
                    link = "http://xvideos.com/video3228565/858936_sexy_thick_ebony_indian_chick_revenge_strip_ameman"
                ),
                Episode(
                    number = 46,
                    animeName = "Loira casada do rabo gigante tirando a camisinha",
                    image = "https://img-egc.xvideos-cdn.com/videos/thumbs169/c5/15/0d/c5150d3438ac817fc07d95def91b5225/c5150d3438ac817fc07d95def91b5225.9.jpg",
                    description = "7 min",
                    link = "http://xvideos.com/video32247379/loira_casada_do_rabo_gigante_tirando_a_camisinha"
                ),
                Episode(
                    number = 47,
                    animeName = "Fit Brazilian Babe Luna Corazon Masturbates to Orgasm after Workout",
                    image = "https://img-l3.xvideos-cdn.com/videos/thumbs169/7c/40/d6/7c40d6574b9ec5366d2be8b6de3831db/7c40d6574b9ec5366d2be8b6de3831db.1.jpg",
                    description = "18 min",
                    link = "http://xvideos.com/video35495151/fit_brazilian_babe_luna_corazon_masturbates_to_orgasm_after_workout"
                ),
                Episode(
                    number = 48,
                    animeName = "Big Booty Young Black Girl gets Tight Teen Pussy Banged in Amateur Video",
                    image = "https://images-llnw.xvideos-cdn.com/videos/thumbs169/96/7a/d3/967ad394e95d88e9ceca37d5d0f0fda5/967ad394e95d88e9ceca37d5d0f0fda5.2.jpg",
                    description = "1h 20 min",
                    link = "http://xvideos.com/video25660391/big_booty_young_black_girl_gets_tight_teen_pussy_banged_in_amateur_video"
                ),
                Episode(
                    number = 49,
                    animeName = "Hottie is caressing pussy",
                    image = "https://img-l3.xvideos-cdn.com/videos/thumbs169/23/aa/4d/23aa4d5813ab86bfc83fefccc9331a81/23aa4d5813ab86bfc83fefccc9331a81.6.jpg",
                    description = "5 min",
                    link = "http://xvideos.com/video9165798/hottie_is_caressing_pussy"
                ),
                Episode(
                    number = 50,
                    animeName = "Ebony Sex",
                    image = "https://images-llnw.xvideos-cdn.com/videos/thumbs169/8d/da/2a/8dda2aea007d102547d52077bd7ab41d/8dda2aea007d102547d52077bd7ab41d.3.jpg",
                    description = "5 min",
                    link = "http://xvideos.com/video551578/ebony_sex"
                ),
                Episode(
                    number = 51,
                    animeName = "O massagista",
                    image = "https://img-egc.xvideos-cdn.com/videos/thumbs169/54/4a/e6/544ae69f8f43f6f3f55e122b56da514b/544ae69f8f43f6f3f55e122b56da514b.4.jpg",
                    description = "21 min",
                    link = "http://xvideos.com/video79107/o_massagista"
                )
            ),
            temporaryVideoUrl = false
        )
    }

    init {
        FactoryChecker.describe(XvideosFactory) {
            if (UrlFetcher.useCache)
                whenEpisode(currentEpisode)
            else
                xit("when episode") {}
            whenCheckIsEpisode(VALID_URLS, INVALID_URLS)
        }
    }
}
