package com.phisher98;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: StreamPlayExtractor.kt */
/* JADX INFO: loaded from: /home/runner/work/NepaliStream-CNC-Repo/NepaliStream-CNC-Repo/decoded/StreamPlay/Phisher98/java/classes.dex */
@Metadata(k = 3, mv = {2, 4, 0}, xi = 48)
@DebugMetadata(c = "com.phisher98.StreamPlayExtractor", f = "StreamPlayExtractor.kt", i = {0, 0, 0, 0, 0, 0}, l = {3654}, m = "invokeHdmovie2$fetchSource", n = {"ajaxUrl", "commonHeaders", "hdmovie2API", "post", "nume", "type"}, nl = {3664}, s = {"L$0", "L$1", "L$2", "L$3", "L$4", "L$5"}, v = 2)
final class StreamPlayExtractor$invokeHdmovie2$fetchSource$1 extends ContinuationImpl {
    Object L$0;
    Object L$1;
    Object L$2;
    Object L$3;
    Object L$4;
    Object L$5;
    int label;
    /* synthetic */ Object result;

    StreamPlayExtractor$invokeHdmovie2$fetchSource$1(Continuation<? super StreamPlayExtractor$invokeHdmovie2$fetchSource$1> continuation) {
        super(continuation);
    }

    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return StreamPlayExtractor.invokeHdmovie2$fetchSource(null, null, null, null, null, null, (Continuation) this);
    }
}
