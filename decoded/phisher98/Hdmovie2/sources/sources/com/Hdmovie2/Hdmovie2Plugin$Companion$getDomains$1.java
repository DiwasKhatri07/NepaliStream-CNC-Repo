package com.Hdmovie2;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: Hdmovie2Plugin.kt */
/* JADX INFO: loaded from: /home/ubuntu/work/NepaliStream-CNC-Repo/decoded/phisher98/Hdmovie2/classes.dex */
@Metadata(k = 3, mv = {2, 4, 0}, xi = 48)
@DebugMetadata(c = "com.Hdmovie2.Hdmovie2Plugin$Companion", f = "Hdmovie2Plugin.kt", i = {0}, l = {24}, m = "getDomains", n = {"forceRefresh"}, nl = {40}, s = {"Z$0"}, v = 2)
final class Hdmovie2Plugin$Companion$getDomains$1 extends ContinuationImpl {
    Object L$0;
    boolean Z$0;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ Hdmovie2Plugin.Companion this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    Hdmovie2Plugin$Companion$getDomains$1(Hdmovie2Plugin.Companion companion, Continuation<? super Hdmovie2Plugin$Companion$getDomains$1> continuation) {
        super(continuation);
        this.this$0 = companion;
    }

    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.getDomains(false, (Continuation) this);
    }
}
