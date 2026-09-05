package com.phisher98;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: XDMovies.kt */
/* JADX INFO: loaded from: /home/runner/work/NepaliStream-CNC-Repo/NepaliStream-CNC-Repo/decoded/XDMovies/Phisher98/java/classes.dex */
@Metadata(k = 3, mv = {2, 4, 0}, xi = 48)
@DebugMetadata(c = "com.phisher98.XDMovies$Companion", f = "XDMovies.kt", i = {0, 0, 0, 1, 1, 1, 1, 2, 2, 2, 2, 3, 3, 3, 3, 4, 4, 4, 4}, l = {201, 543, 205, 208, 209}, m = "appGet", n = {"url", "headers", "rawResponse", "url", "headers", "rawResponse", "$this$withLock_u24default$iv", "url", "headers", "rawResponse", "$this$withLock_u24default$iv", "url", "headers", "rawResponse", "$this$withLock_u24default$iv", "url", "headers", "rawResponse", "$this$withLock_u24default$iv"}, nl = {202, 544, 206, 209, 211}, s = {"L$0", "L$1", "L$2", "L$0", "L$1", "L$2", "L$3", "L$0", "L$1", "L$2", "L$3", "L$0", "L$1", "L$2", "L$3", "L$0", "L$1", "L$2", "L$3"}, v = 2)
final class XDMovies$Companion$appGet$1 extends ContinuationImpl {
    Object L$0;
    Object L$1;
    Object L$2;
    Object L$3;
    Object L$4;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ XDMovies.Companion this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    XDMovies$Companion$appGet$1(XDMovies.Companion companion, Continuation<? super XDMovies$Companion$appGet$1> continuation) {
        super(continuation);
        this.this$0 = companion;
    }

    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.appGet(null, null, (Continuation) this);
    }
}
