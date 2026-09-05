package com.phisher98;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: StreamPlayStremioCatelog.kt */
/* JADX INFO: loaded from: /home/ubuntu/work/NepaliStream-CNC-Repo/decoded/phisher98/StreamPlay/classes.dex */
@Metadata(k = 3, mv = {2, 4, 0}, xi = 48)
@DebugMetadata(c = "com.phisher98.StreamPlayStremioCatelog$Catalog", f = "StreamPlayStremioCatelog.kt", i = {0, 0, 0, 0, 0, 0, 0}, l = {242}, m = "toHomePageList", n = {"provider", "entries", "$this$forEach$iv", "element$iv", "type", "url", "skip"}, nl = {245}, s = {"L$0", "L$1", "L$2", "L$4", "L$5", "L$6", "I$0"}, v = 2)
final class StreamPlayStremioCatelog$Catalog$toHomePageList$1 extends ContinuationImpl {
    int I$0;
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
    StreamPlayStremioCatelog$Catalog$toHomePageList$1(StreamPlayStremioCatelog.Catalog catalog, Continuation<? super StreamPlayStremioCatelog$Catalog$toHomePageList$1> continuation) {
        super(continuation);
        this.this$0 = catalog;
    }

    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.toHomePageList(null, 0, (Continuation) this);
    }
}
