package com.phisher98;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: StreamPlay.kt */
/* JADX INFO: loaded from: /home/runner/work/NepaliStream-CNC-Repo/NepaliStream-CNC-Repo/decoded/StreamPlay/Phisher98/java/classes.dex */
@Metadata(k = 3, mv = {2, 4, 0}, xi = 48)
@DebugMetadata(c = "com.phisher98.StreamPlay$Companion", f = "StreamPlay.kt", i = {}, l = {160}, m = "fetchProxyList", n = {}, nl = {161}, s = {}, v = 2)
final class StreamPlay$Companion$fetchProxyList$1 extends ContinuationImpl {
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ StreamPlay.Companion this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    StreamPlay$Companion$fetchProxyList$1(StreamPlay.Companion companion, Continuation<? super StreamPlay$Companion$fetchProxyList$1> continuation) {
        super(continuation);
        this.this$0 = companion;
    }

    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.fetchProxyList((Continuation) this);
    }
}
