/*
 * Copyright 2022 Google LLC All Rights Reserved.
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
package com.google.api.gax.grpc

import io.grpc.{ClientInterceptor, ManagedChannel}
import com.google.api.gax.grpc.ChannelPoolSettings

/** Expose package private classes */
object ChannelUtil {
  def createPool(poolSize: Int, channelFactory: ChannelFactory): ManagedChannel =
    ChannelPool.create(ChannelPoolSettings.builder().setMaxChannelCount(poolSize).build(), channelFactory)
  def metaInterceptor: ClientInterceptor = new GrpcMetadataHandlerInterceptor
  def uuidInterceptor: ClientInterceptor = new GrpcChannelUUIDInterceptor
}
