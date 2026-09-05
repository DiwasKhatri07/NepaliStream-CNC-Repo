package com.phisher98;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: AnimePahe.kt */
/* JADX INFO: loaded from: /home/runner/work/NepaliStream-CNC-Repo/NepaliStream-CNC-Repo/decoded/AnimePahe/Phisher98/java/classes.dex */
@Metadata(k = 3, mv = {2, 4, 0}, xi = 48)
@DebugMetadata(c = "com.phisher98.AnimePahe$LinkLoadData", f = "AnimePahe.kt", i = {0}, l = {271}, m = "getUrl", n = {"url"}, nl = {544}, s = {"L$0"}, v = 2)
final class AnimePahe$LinkLoadData$getUrl$1 extends ContinuationImpl {
    Object L$0;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ AnimePahe.LinkLoadData this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    AnimePahe$LinkLoadData$getUrl$1(AnimePahe.LinkLoadData linkLoadData, Continuation<? super AnimePahe$LinkLoadData$getUrl$1> continuation) {
        super(continuation);
        this.this$0 = linkLoadData;
    }

    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.getUrl((Continuation) this);
    }
}
