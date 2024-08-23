#include <jni.h>
#include <string>

extern "C" JNIEXPORT jstring JNICALL
Java_com_chamith_hwaddress_1sanitizer_MainActivity_stringFromJNI(
        JNIEnv* env,
        jobject /* this */) {

    // use after free
    int *foo = new int;
    *foo = 3;
    delete foo;
    *foo = 4;

    std::string hello = "Hello from C++";
    return env->NewStringUTF(hello.c_str());
}