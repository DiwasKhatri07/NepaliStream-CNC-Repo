package com.tamilblasters;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: TamilblastersPlugin.kt */
/* JADX INFO: loaded from: /home/ubuntu/work/NepaliStream-CNC-Repo/decoded/phisher98/Tamilblasters/classes.dex */
@Metadata(k = 3, mv = {2, 4, 0}, xi = 48)
@DebugMetadata(c = "com.tamilblasters.TamilblastersPlugin$Companion", f = "TamilblastersPlugin.kt", i = {0}, l = {26}, m = "getDomains", n = {"forceRefresh"}, nl = {42}, s = {"Z$0"}, v = 2)
final class TamilblastersPlugin$Companion$getDomains$1 extends ContinuationImpl {
    Object L$0;
    boolean Z$0;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ TamilblastersPlugin.Companion this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    TamilblastersPlugin$Companion$getDomains$1(TamilblastersPlugin.Companion companion, Continuation<? super TamilblastersPlugin$Companion$getDomains$1> continuation) {
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
