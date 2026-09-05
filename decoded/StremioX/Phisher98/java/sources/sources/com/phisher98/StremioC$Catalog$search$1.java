package com.phisher98;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: StremioC.kt */
/* JADX INFO: loaded from: /home/runner/work/NepaliStream-CNC-Repo/NepaliStream-CNC-Repo/decoded/StremioX/Phisher98/java/classes.dex */
@Metadata(k = 3, mv = {2, 4, 0}, xi = 48)
@DebugMetadata(c = "com.phisher98.StremioC$Catalog", f = "StremioC.kt", i = {0, 0}, l = {359}, m = "search", n = {"query", "provider"}, nl = {363}, s = {"L$0", "L$1"}, v = 2)
final class StremioC$Catalog$search$1 extends ContinuationImpl {
    Object L$0;
    Object L$1;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ StremioC.Catalog this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    StremioC$Catalog$search$1(StremioC.Catalog catalog, Continuation<? super StremioC$Catalog$search$1> continuation) {
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
