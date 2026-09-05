package com.RingZ;

import com.lagradost.cloudstream3.MainAPIKt;
import com.lagradost.cloudstream3.MainPageData;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: compiled from: RingZ.kt */
/* JADX INFO: loaded from: /home/runner/work/NepaliStream-CNC-Repo/NepaliStream-CNC-Repo/decoded/RingZ/Phisher98/java/classes.dex */
@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001*\u00020\u0003H\n"}, d2 = {"<anonymous>", "", "Lcom/lagradost/cloudstream3/MainPageData;", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 4, 0}, xi = 48)
@DebugMetadata(c = "com.RingZ.RingZ$mainPage$1", f = "RingZ.kt", i = {}, l = {133}, m = "invokeSuspend", n = {}, nl = {134}, s = {}, v = 2)
@SourceDebugExtension({"SMAP\nRingZ.kt\nKotlin\n*S Kotlin\n*F\n+ 1 RingZ.kt\ncom/RingZ/RingZ$mainPage$1\n+ 2 ArraysJVM.kt\nkotlin/collections/ArraysKt__ArraysJVMKt\n*L\n1#1,630:1\n37#2,2:631\n*S KotlinDebug\n*F\n+ 1 RingZ.kt\ncom/RingZ/RingZ$mainPage$1\n*L\n135#1:631,2\n*E\n"})
final class RingZ$mainPage$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super List<? extends MainPageData>>, Object> {
    int label;
    final /* synthetic */ RingZ this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    RingZ$mainPage$1(RingZ ringZ, Continuation<? super RingZ$mainPage$1> continuation) {
        super(2, continuation);
        this.this$0 = ringZ;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new RingZ$mainPage$1(this.this$0, continuation);
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super List<MainPageData>> continuation) {
        return create(coroutineScope, continuation).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object $result) {
        Object objFetchMainPageFromApi;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        try {
            switch (this.label) {
                case 0:
                    ResultKt.throwOnFailure($result);
                    this.label = 1;
                    objFetchMainPageFromApi = this.this$0.fetchMainPageFromApi((Continuation) this);
                    if (objFetchMainPageFromApi == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    break;
                case 1:
                    ResultKt.throwOnFailure($result);
                    objFetchMainPageFromApi = $result;
                    break;
                default:
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            Collection pages = (List) objFetchMainPageFromApi;
            if (pages.isEmpty()) {
                return this.this$0.defaultMainPage();
            }
            Collection $this$toTypedArray$iv = pages;
            Pair[] pairArr = (Pair[]) $this$toTypedArray$iv.toArray(new Pair[0]);
            return MainAPIKt.mainPageOf((Pair[]) Arrays.copyOf(pairArr, pairArr.length));
        } catch (Throwable th) {
            return this.this$0.defaultMainPage();
        }
    }
}
