package com.zinkmovies;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: Zinkmovies.kt */
/* JADX INFO: loaded from: /home/runner/work/NepaliStream-CNC-Repo/NepaliStream-CNC-Repo/decoded/Zinkmovies/Phisher98/java/classes.dex */
@Metadata(k = 3, mv = {2, 4, 0}, xi = 48)
@DebugMetadata(c = "com.zinkmovies.Zinkmovies$Companion", f = "Zinkmovies.kt", i = {0, 0, 0, 0, 1, 1, 1, 1, 1, 1, 1, 2, 2, 2, 2, 2, 2, 2, 3, 3, 3, 3, 3, 3, 3, 3, 4, 4, 4, 4, 4, 4}, l = {169, 723, 180, 190, 195}, m = "appGet", n = {"url", "headers", "cacheTime", "allowRedirects", "url", "headers", "rawResponse", "recheckPassed", "$this$withLock_u24default$iv", "cacheTime", "allowRedirects", "url", "headers", "rawResponse", "recheckPassed", "$this$withLock_u24default$iv", "cacheTime", "allowRedirects", "url", "headers", "rawResponse", "recheckPassed", "$this$withLock_u24default$iv", "recheck", "cacheTime", "allowRedirects", "url", "headers", "rawResponse", "recheckPassed", "cacheTime", "allowRedirects"}, nl = {176, 724, 187, 192, 202}, s = {"L$0", "L$1", "I$0", "Z$0", "L$0", "L$1", "L$2", "L$3", "L$4", "I$0", "Z$0", "L$0", "L$1", "L$2", "L$3", "L$4", "I$0", "Z$0", "L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "I$0", "Z$0", "L$0", "L$1", "L$2", "L$3", "I$0", "Z$0"}, v = 2)
final class Zinkmovies$Companion$appGet$1 extends ContinuationImpl {
    int I$0;
    Object L$0;
    Object L$1;
    Object L$2;
    Object L$3;
    Object L$4;
    Object L$5;
    boolean Z$0;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ Zinkmovies.Companion this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    Zinkmovies$Companion$appGet$1(Zinkmovies.Companion companion, Continuation<? super Zinkmovies$Companion$appGet$1> continuation) {
        super(continuation);
        this.this$0 = companion;
    }

    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.appGet(null, null, 0, false, (Continuation) this);
    }
}
