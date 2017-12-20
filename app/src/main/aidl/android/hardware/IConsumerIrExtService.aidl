/**
 * Copyright (c) 2013, The Android Open Source Project
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

package android.hardware;

/** {@hide} */
interface IConsumerIrExtService
{
    boolean hasIrEmitter();
    void transmit(String packageName, int carrierFrequency, in int[] pattern);
    int[] getCarrierFrequencies();
	int input_ir_ext_key_once(String protocol, int vendor_code, int keycode, int repeat);
	int setup_ir_ext_procotol(String protocol);
	int input_ir_ext_key(int vendor_code, int keycode, int repeat);
}

