#include <jni.h>
#include <string>

extern "C"
JNIEXPORT jstring JNICALL
Java_uk_ac_cam_sc989_langagrams_HomeScreen_stringFromJNI(
        JNIEnv *env,
        jobject /* this */) {
    std::string hello = "Hello from C++";
    return env->NewStringUTF(hello.c_str());
}
