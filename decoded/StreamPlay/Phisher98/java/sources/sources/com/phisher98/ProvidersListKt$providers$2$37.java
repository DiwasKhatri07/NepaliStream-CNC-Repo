package com.phisher98;

import com.lagradost.cloudstream3.SubtitleFile;
import com.lagradost.cloudstream3.utils.ExtractorLink;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SpillingKt;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function6;

/* JADX INFO: compiled from: ProvidersList.kt */
/* JADX INFO: loaded from: /home/runner/work/NepaliStream-CNC-Repo/NepaliStream-CNC-Repo/decoded/StreamPlay/Phisher98/java/classes.dex */
@Metadata(d1 = {"\u0000 \n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0012\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00010\u00052\u0012\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\u00010\u00052\u0006\u0010\u0004\u001a\u00020\t2\u0006\u0010\u0004\u001a\u00020\tH\n"}, d2 = {"<anonymous>", "", "res", "Lcom/phisher98/StreamPlay$LinkData;", "<unused var>", "Lkotlin/Function1;", "Lcom/lagradost/cloudstream3/SubtitleFile;", "callback", "Lcom/lagradost/cloudstream3/utils/ExtractorLink;", ""}, k = 3, mv = {2, 4, 0}, xi = 48)
@DebugMetadata(c = "com.phisher98.ProvidersListKt$providers$2$37", f = "ProvidersList.kt", i = {0, 0}, l = {283}, m = "invokeSuspend", n = {"res", "callback"}, nl = {284}, s = {"L$0", "L$1"}, v = 2)
final class ProvidersListKt$providers$2$37 extends SuspendLambda implements Function6<StreamPlay.LinkData, Function1<? super SubtitleFile, ? extends Unit>, Function1<? super ExtractorLink, ? extends Unit>, String, String, Continuation<? super Unit>, Object> {
    /* synthetic */ Object L$0;
    /* synthetic */ Object L$1;
    int label;

    ProvidersListKt$providers$2$37(Continuation<? super ProvidersListKt$providers$2$37> continuation) {
        super(6, continuation);
    }

    public final Object invoke(StreamPlay.LinkData linkData, Function1<? super SubtitleFile, Unit> function1, Function1<? super ExtractorLink, Unit> function2, String str, String str2, Continuation<? super Unit> continuation) {
        ProvidersListKt$providers$2$37 providersListKt$providers$2$37 = new ProvidersListKt$providers$2$37(continuation);
        providersListKt$providers$2$37.L$0 = linkData;
        providersListKt$providers$2$37.L$1 = function2;
        return providersListKt$providers$2$37.invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object $result) {
        StreamPlay.LinkData res = (StreamPlay.LinkData) this.L$0;
        Function1<? super ExtractorLink, Unit> function1 = (Function1) this.L$1;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (this.label) {
            case 0:
                ResultKt.throwOnFailure($result);
                if (!res.isAnime()) {
                    this.L$0 = SpillingKt.nullOutSpilledVariable(res);
                    this.L$1 = SpillingKt.nullOutSpilledVariable(function1);
                    this.label = 1;
                    if (StreamPlayExtractor.INSTANCE.invokeDahmerMovies(res.getTitle(), res.getYear(), res.getSeason(), res.getEpisode(), function1, (Continuation) this) == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                }
                break;
            case 1:
                ResultKt.throwOnFailure($result);
                break;
            default:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        return Unit.INSTANCE;
    }
}
