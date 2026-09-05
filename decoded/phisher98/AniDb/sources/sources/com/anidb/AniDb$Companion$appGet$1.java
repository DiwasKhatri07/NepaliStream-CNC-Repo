package com.anidb;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: AniDb.kt */
/* JADX INFO: loaded from: /home/ubuntu/work/NepaliStream-CNC-Repo/decoded/phisher98/AniDb/classes.dex */
@Metadata(k = 3, mv = {2, 4, 0}, xi = 48)
@DebugMetadata(c = "com.anidb.AniDb$Companion", f = "AniDb.kt", i = {0, 0, 1, 1, 1, 1, 1, 2, 2, 2, 2, 2, 3, 3, 3, 3, 3, 3, 4, 4, 4, 4}, l = {126, 442, 131, 135, 140}, m = "appGet", n = {"url", "headers", "url", "headers", "rawResponse", "recheckPassed", "$this$withLock_u24default$iv", "url", "headers", "rawResponse", "recheckPassed", "$this$withLock_u24default$iv", "url", "headers", "rawResponse", "recheckPassed", "$this$withLock_u24default$iv", "recheck", "url", "headers", "rawResponse", "recheckPassed"}, nl = {127, 443, 132, 137, -1}, s = {"L$0", "L$1", "L$0", "L$1", "L$2", "L$3", "L$4", "L$0", "L$1", "L$2", "L$3", "L$4", "L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$0", "L$1", "L$2", "L$3"}, v = 2)
final class AniDb$Companion$appGet$1 extends ContinuationImpl {
    Object L$0;
    Object L$1;
    Object L$2;
    Object L$3;
    Object L$4;
    Object L$5;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ AniDb.Companion this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    AniDb$Companion$appGet$1(AniDb.Companion companion, Continuation<? super AniDb$Companion$appGet$1> continuation) {
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
