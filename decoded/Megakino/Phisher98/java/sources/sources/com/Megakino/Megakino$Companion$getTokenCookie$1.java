package com.Megakino;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: Megakino.kt */
/* JADX INFO: loaded from: /home/runner/work/NepaliStream-CNC-Repo/NepaliStream-CNC-Repo/decoded/Megakino/Phisher98/java/classes.dex */
@Metadata(k = 3, mv = {2, 4, 0}, xi = 48)
@DebugMetadata(c = "com.Megakino.Megakino$Companion", f = "Megakino.kt", i = {}, l = {23}, m = "getTokenCookie", n = {}, nl = {24}, s = {}, v = 2)
final class Megakino$Companion$getTokenCookie$1 extends ContinuationImpl {
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ Megakino.Companion this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    Megakino$Companion$getTokenCookie$1(Megakino.Companion companion, Continuation<? super Megakino$Companion$getTokenCookie$1> continuation) {
        super(continuation);
        this.this$0 = companion;
    }

    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.getTokenCookie((Continuation) this);
    }
}
