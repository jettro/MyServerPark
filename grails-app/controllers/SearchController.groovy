/*
 * Copyright (c) 2009. Gridshore
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

class SearchController {

    def search = {
        def query = params.q

        if (!query) {
            return [:]
        }

        try {
            params.withHighlighter = {highlighter, index, sr ->
                if (!sr.highlights) {
                    sr.highlights = []
                }
                def matchedFragment = highlighter.fragment("content")
                sr.highlights[index] = "..." + (matchedFragment ?:"") + "..."
            }

            def searchResult = Comment.search (query,params)
            return [searchResult:searchResult]
        } catch (e) {
            return [searchError:true]
        }
    }
}
