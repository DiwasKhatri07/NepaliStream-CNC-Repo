package com.fourKHDHub;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: FourKHDHubProvider.kt */
/* JADX INFO: loaded from: /home/runner/work/NepaliStream-CNC-Repo/NepaliStream-CNC-Repo/decoded/FourKHDHub/Phisher98/java/classes.dex */
@Metadata(k = 3, mv = {2, 4, 0}, xi = 48)
@DebugMetadata(c = "com.fourKHDHub.FourKHDHubProvider$Companion", f = "FourKHDHubProvider.kt", i = {0}, l = {29}, m = "getDomains", n = {"forceRefresh"}, nl = {46}, s = {"Z$0"}, v = 2)
final class FourKHDHubProvider$Companion$getDomains$1 extends ContinuationImpl {
    Object L$0;
    boolean Z$0;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ FourKHDHubProvider.Companion this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    FourKHDHubProvider$Companion$getDomains$1(FourKHDHubProvider.Companion companion, Continuation<? super FourKHDHubProvider$Companion$getDomains$1> continuation) {
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
