/*
 * Copyright 2020 Appmattus Limited
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.appmattus.layercache

/**
 * Simple cache that stores values associated with keys in a map with no expiration or cleanup logic. Use at your own
 * risk.
 */
class MapCache : Cache<String, String> {
    private val map = mutableMapOf<String, String?>()

    override suspend fun get(key: String): String? {
        return map[key]
    }

    override suspend fun set(key: String, value: String) {
        map[key] = value
    }

    override suspend fun evict(key: String) {
        map.remove(key)
    }

    override suspend fun evictAll() {
        map.clear()
    }
}
