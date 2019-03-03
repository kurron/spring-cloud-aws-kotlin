package org.kurron.spring.cloud.aws

import org.commonmark.ext.autolink.AutolinkExtension
import org.commonmark.parser.Parser
import org.commonmark.renderer.html.HtmlRenderer
import org.springframework.stereotype.Service

@Service
class MarkdownConverter : (String?) -> String { // TODO: figure out what this syntax means!

    private val parser = Parser.builder().extensions( listOf( AutolinkExtension.create() ) ).build()
    private val render = HtmlRenderer.builder().build()

    override fun invoke( input: String? ) : String {
        if ( input == null || input == "" ) {
            return ""
        }
        return render.render( parser.parse( input ) )
    }
}