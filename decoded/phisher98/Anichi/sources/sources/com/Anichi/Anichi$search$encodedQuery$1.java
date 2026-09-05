package com.Anichi;

import com.lagradost.cloudstream3.utils.StringUtils;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: compiled from: Anichi.kt */
/* JADX INFO: loaded from: /home/ubuntu/work/NepaliStream-CNC-Repo/decoded/phisher98/Anichi/classes.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u000e\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 4, 0}, xi = 48)
@DebugMetadata(c = "com.Anichi.Anichi$search$encodedQuery$1", f = "Anichi.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, nl = {}, s = {}, v = 2)
@SourceDebugExtension({"SMAP\nAnichi.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Anichi.kt\ncom/Anichi/Anichi$search$encodedQuery$1\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,376:1\n1#2:377\n*E\n"})
final class Anichi$search$encodedQuery$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super String>, Object> {
    final /* synthetic */ String $query;
    int label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    Anichi$search$encodedQuery$1(String str, Continuation<? super Anichi$search$encodedQuery$1> continuation) {
        super(2, continuation);
        this.$query = str;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new Anichi$search$encodedQuery$1(this.$query, continuation);
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super String> continuation) {
        return create(coroutineScope, continuation).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object $result) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (this.label) {
            case 0:
                ResultKt.throwOnFailure($result);
                StringUtils $this$invokeSuspend_u24lambda_u240 = StringUtils.INSTANCE;
                return $this$invokeSuspend_u24lambda_u240.encodeUrl(this.$query);
            default:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }
}
