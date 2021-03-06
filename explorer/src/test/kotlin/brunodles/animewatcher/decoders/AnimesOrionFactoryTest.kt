package brunodles.animewatcher.decoders

import brunodles.animewatcher.explorer.Episode
import brunodles.animewatcher.testhelper.FactoryChecker
import brunodles.animewatcher.testhelper.FactoryChecker.whenCheckIsEpisode
import brunodles.animewatcher.testhelper.FactoryChecker.whenEpisode
import com.greghaskins.spectrum.Spectrum
import com.greghaskins.spectrum.Spectrum.describe
import org.junit.runner.RunWith

@RunWith(Spectrum::class)
class AnimesOrionFactoryTest {

    companion object {
        val VALID_URLS = arrayOf("http://www.animesorion.video/71672",
                "http://www.animesorion.tv/71672",
                "https://www.animesorion.site/71672")
        val INVALID_URLS = emptyArray<String>()
        val SINGLE_NEXT_EPISODES = Episode(
                number = 2,
                description = "Boku No Hero Academia Episódio 2",
                animeName = "Boku No Hero Academia 1",
                image = null,
                link = "https://www.animesorion.site/71672",
                video = "https://www.blogger.com/video-play.mp4?contentId=b0bccad36e2be8e1",
                nextEpisodes = arrayListOf(
                        Episode(number = 3,
                                description = "Next",
                                animeName = "Boku No Hero Academia 1",
                                image = null,
                                link = "https://www.animesorion.video/71808")
                )
        )
        val NO_NEXT_EPISODES = Episode(
                number = 12,
                description = "Himouto! Umaru-chan Episódio 12 – FINAL",
                animeName = "Himouto! Umaru-chan 1 Legendado",
                image = null,
                link = "http://www.animesorion.tv/51555",
                video = "https://www.blogger.com/video-play.mp4?contentId=e4e3e680e0b6ed74",
                nextEpisodes = emptyList()
        )

        val ABOUTPAGE_EPISODES = Episode(
                number = 1,
                description = "Boku No Hero Academia 2 Episódio 1",
                animeName = "Boku No Hero Academia 2",
                image = null,
                link = "https://www.animesorion.video/81318",
                video = "https://www.blogger.com/video-play.mp4?contentId=59a70b30c1bf47a0",
                nextEpisodes = arrayListOf(
                        Episode(number = 2, description = "Boku No Hero Academia 2 Episódio 2", animeName = "Boku No Hero Academia 2", link = "https://www.animesorion.video/81518"),
                        Episode(number = 3, description = "Boku No Hero Academia 2 Episódio 3", animeName = "Boku No Hero Academia 2", link = "https://www.animesorion.video/81679"),
                        Episode(number = 4, description = "Boku No Hero Academia 2 Episódio 4", animeName = "Boku No Hero Academia 2", link = "https://www.animesorion.video/81926"),
                        Episode(number = 5, description = "Boku No Hero Academia 2 Episódio 5", animeName = "Boku No Hero Academia 2", link = "https://www.animesorion.video/82143"),
                        Episode(number = 6, description = "Boku No Hero Academia 2 Episódio 6", animeName = "Boku No Hero Academia 2", link = "https://www.animesorion.video/82162"),
                        Episode(number = 7, description = "Boku No Hero Academia 2 Episódio 7", animeName = "Boku No Hero Academia 2", link = "https://www.animesorion.video/82459"),
                        Episode(number = 8, description = "Boku No Hero Academia 2 Episódio 8", animeName = "Boku No Hero Academia 2", link = "https://www.animesorion.video/84237"),
                        Episode(number = 9, description = "Boku No Hero Academia 2 Episódio 9", animeName = "Boku No Hero Academia 2", link = "https://www.animesorion.video/93021"),
                        Episode(number = 10, description = "Boku No Hero Academia 2 Episódio 10", animeName = "Boku No Hero Academia 2", link = "https://www.animesorion.video/105627"),
                        Episode(number = 11, description = "Boku No Hero Academia 2 Episódio 11", animeName = "Boku No Hero Academia 2", link = "https://www.animesorion.video/111799"),
                        Episode(number = 12, description = "Boku No Hero Academia 2 Episódio 12", animeName = "Boku No Hero Academia 2", link = "https://www.animesorion.video/112034"),
                        Episode(number = 13, description = "Boku No Hero Academia 2 Episódio 13", animeName = "Boku No Hero Academia 2", link = "https://www.animesorion.video/112396"),
                        Episode(number = 14, description = "Boku No Hero Academia 2 Episódio 14", animeName = "Boku No Hero Academia 2", link = "https://www.animesorion.video/112524"),
                        Episode(number = 15, description = "Boku No Hero Academia 2 Episódio 15", animeName = "Boku No Hero Academia 2", link = "https://www.animesorion.video/113447"),
                        Episode(number = 16, description = "Boku No Hero Academia 2 Episódio 16", animeName = "Boku No Hero Academia 2", link = "https://www.animesorion.video/113752"),
                        Episode(number = 17, description = "Boku No Hero Academia 2 Episódio 17", animeName = "Boku No Hero Academia 2", link = "https://www.animesorion.video/113881"),
                        Episode(number = 18, description = "Boku No Hero Academia 2 Episódio 18", animeName = "Boku No Hero Academia 2", link = "https://www.animesorion.video/114039"),
                        Episode(number = 19, description = "Boku No Hero Academia 2 Episódio 19", animeName = "Boku No Hero Academia 2", link = "https://www.animesorion.video/114191"),
                        Episode(number = 20, description = "Boku No Hero Academia 2 Episódio 20", animeName = "Boku No Hero Academia 2", link = "https://www.animesorion.video/114346"),
                        Episode(number = 21, description = "Boku No Hero Academia 2 Episódio 21", animeName = "Boku No Hero Academia 2", link = "https://www.animesorion.video/114525"),
                        Episode(number = 22, description = "Boku No Hero Academia 2 Episódio 22", animeName = "Boku No Hero Academia 2", link = "https://www.animesorion.video/114873"),
                        Episode(number = 23, description = "Boku No Hero Academia 2 Episódio 23", animeName = "Boku No Hero Academia 2", link = "https://www.animesorion.video/115039"),
                        Episode(number = 24, description = "Boku No Hero Academia 2 Episódio 24", animeName = "Boku No Hero Academia 2", link = "https://www.animesorion.video/115218"),
                        Episode(number = 25, description = "Boku No Hero Academia 2 Episódio 25 / FINAL", animeName = "Boku No Hero Academia 2", link = "https://www.animesorion.video/115418")
                )
        )
    }

    init {
        FactoryChecker.describe(AnimesOrionFactory) {
            describe("when single next episodes") {
                whenEpisode(SINGLE_NEXT_EPISODES)
            }
            describe("when about page") {
                whenEpisode(ABOUTPAGE_EPISODES)
            }
            describe("when no next episodes") {
                whenEpisode(NO_NEXT_EPISODES)
            }
            whenCheckIsEpisode(VALID_URLS, INVALID_URLS)
        }
    }
}