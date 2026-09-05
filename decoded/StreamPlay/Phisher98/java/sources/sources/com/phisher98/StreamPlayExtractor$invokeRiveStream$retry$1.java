package com.phisher98;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: StreamPlayExtractor.kt */
/* JADX INFO: loaded from: /home/ubuntu/work/NepaliStream-CNC-Repo/decoded/phisher98/StreamPlay/classes.dex */
@Metadata(k = 3, mv = {2, 4, 0}, xi = 48)
@DebugMetadata(c = "com.phisher98.StreamPlayExtractor", f = "StreamPlayExtractor.kt", i = {0, 0, 0, 1, 1}, l = {3052, 3057}, m = "invokeRiveStream$retry", n = {"block", "times", "it", "block", "times"}, nl = {3053, 3058}, s = {"L$0", "I$0", "I$3", "L$0", "I$0"}, v = 2)
final class StreamPlayExtractor$invokeRiveStream$retry$1<T> extends ContinuationImpl {
    int I$0;
    int I$1;
    int I$2;
    int I$3;
    Object L$0;
    int label;
    /* synthetic */ Object result;

    StreamPlayExtractor$invokeRiveStream$retry$1(Continuation<? super StreamPlayExtractor$invokeRiveStream$retry$1> continuation) {
        super(continuation);
    }

    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return StreamPlayExtractor.invokeRiveStream$retry(0, null, (Continuation) this);
    }
}
