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
@DebugMetadata(c = "com.phisher98.StreamPlayExtractor", f = "StreamPlayExtractor.kt", i = {0, 0, 0, 0}, l = {2450}, m = "invokeVegamovies$fetchResults", n = {"api", "headers", "query", "url"}, nl = {2451}, s = {"L$0", "L$1", "L$2", "L$3"}, v = 2)
final class StreamPlayExtractor$invokeVegamovies$fetchResults$1 extends ContinuationImpl {
    Object L$0;
    Object L$1;
    Object L$2;
    Object L$3;
    int label;
    /* synthetic */ Object result;

    StreamPlayExtractor$invokeVegamovies$fetchResults$1(Continuation<? super StreamPlayExtractor$invokeVegamovies$fetchResults$1> continuation) {
        super(continuation);
    }

    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return StreamPlayExtractor.invokeVegamovies$fetchResults(null, null, null, (Continuation) this);
    }
}
