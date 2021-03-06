package brunodles.animewatcher.explorer

interface PageParser {

    fun isEpisode(url: String): Boolean

    fun episode(url: String): Episode
}