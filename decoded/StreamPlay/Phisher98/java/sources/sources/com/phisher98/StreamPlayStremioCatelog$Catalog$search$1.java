package com.phisher98;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: StreamPlayStremioCatelog.kt */
/* JADX INFO: loaded from: /home/runner/work/NepaliStream-CNC-Repo/NepaliStream-CNC-Repo/decoded/StreamPlay/Phisher98/java/classes.dex */
@Metadata(k = 3, mv = {2, 4, 0}, xi = 48)
@DebugMetadata(c = "com.phisher98.StreamPlayStremioCatelog$Catalog", f = "StreamPlayStremioCatelog.kt", i = {0, 0, 0, 0, 0, 0}, l = {221}, m = "search", n = {"query", "provider", "entries", "$this$forEach$iv", "element$iv", "type"}, nl = {224}, s = {"L$0", "L$1", "L$2", "L$3", "L$5", "L$6"}, v = 2)
final class StreamPlayStremioCatelog$Catalog$search$1 extends ContinuationImpl {
    Object L$0;
    Object L$1;
    Object L$2;
    Object L$3;
    Object L$4;
    Object L$5;
    Object L$6;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ StreamPlayStremioCatelog.Catalog this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    StreamPlayStremioCatelog$Catalog$search$1(StreamPlayStremioCatelog.Catalog catalog, Continuation<? super StreamPlayStremioCatelog$Catalog$search$1> continuation) {
        super(continuation);
        this.this$0 = catalog;
    }

    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.search(null, null, (Continuation) this);
    }
}
