package com.phisher98;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: StreamPlay.kt */
/* JADX INFO: loaded from: /home/ubuntu/work/NepaliStream-CNC-Repo/decoded/phisher98/StreamPlay/classes.dex */
@Metadata(k = 3, mv = {2, 4, 0}, xi = 48)
@DebugMetadata(c = "com.phisher98.StreamPlay$Companion", f = "StreamPlay.kt", i = {1, 2, 3, 4, 5, 5, 6, 6, 7, 7, 7, 8, 8, 8}, l = {96, 935, 105, 108, 112, 115, 119, 131, 137}, m = "getApiBase", n = {"$this$withLock_u24default$iv", "$this$withLock_u24default$iv", "$this$withLock_u24default$iv", "$this$withLock_u24default$iv", "$this$withLock_u24default$iv", "proxies", "$this$withLock_u24default$iv", "proxies", "$this$withLock_u24default$iv", "proxies", "workingProxy", "$this$withLock_u24default$iv", "proxies", "workingProxy"}, nl = {97, 936, 106, 109, 113, 116, 128, 132, 138}, s = {"L$0", "L$0", "L$0", "L$0", "L$0", "L$1", "L$0", "L$1", "L$0", "L$1", "L$2", "L$0", "L$1", "L$2"}, v = 2)
final class StreamPlay$Companion$getApiBase$1 extends ContinuationImpl {
    Object L$0;
    Object L$1;
    Object L$2;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ StreamPlay.Companion this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    StreamPlay$Companion$getApiBase$1(StreamPlay.Companion companion, Continuation<? super StreamPlay$Companion$getApiBase$1> continuation) {
        super(continuation);
        this.this$0 = companion;
    }

    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.getApiBase((Continuation) this);
    }
}
