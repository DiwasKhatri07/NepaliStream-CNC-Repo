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
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: ProvidersList.kt */
/* JADX INFO: loaded from: /home/ubuntu/work/NepaliStream-CNC-Repo/decoded/phisher98/StreamPlay/classes.dex */
@Metadata(d1 = {"\u0000\"\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0012\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00010\u00052\u0012\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\u00010\u00052\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u0004\u001a\u00020\nH\n"}, d2 = {"<anonymous>", "", "res", "Lcom/phisher98/StreamPlay$LinkData;", "<unused var>", "Lkotlin/Function1;", "Lcom/lagradost/cloudstream3/SubtitleFile;", "callback", "Lcom/lagradost/cloudstream3/utils/ExtractorLink;", "token", ""}, k = 3, mv = {2, 4, 0}, xi = 48)
@DebugMetadata(c = "com.phisher98.ProvidersListKt$providers$2$26", f = "ProvidersList.kt", i = {0, 0, 0, 0, 0}, l = {241}, m = "invokeSuspend", n = {"res", "callback", "token", "status", "isAnime"}, nl = {250}, s = {"L$0", "L$1", "L$2", "L$3", "Z$0"}, v = 2)
final class ProvidersListKt$providers$2$26 extends SuspendLambda implements Function6<StreamPlay.LinkData, Function1<? super SubtitleFile, ? extends Unit>, Function1<? super ExtractorLink, ? extends Unit>, String, String, Continuation<? super Unit>, Object> {
    /* synthetic */ Object L$0;
    /* synthetic */ Object L$1;
    /* synthetic */ Object L$2;
    Object L$3;
    boolean Z$0;
    int label;

    ProvidersListKt$providers$2$26(Continuation<? super ProvidersListKt$providers$2$26> continuation) {
        super(6, continuation);
    }

    public final Object invoke(StreamPlay.LinkData linkData, Function1<? super SubtitleFile, Unit> function1, Function1<? super ExtractorLink, Unit> function2, String str, String str2, Continuation<? super Unit> continuation) {
        ProvidersListKt$providers$2$26 providersListKt$providers$2$26 = new ProvidersListKt$providers$2$26(continuation);
        providersListKt$providers$2$26.L$0 = linkData;
        providersListKt$providers$2$26.L$1 = function2;
        providersListKt$providers$2$26.L$2 = str;
        return providersListKt$providers$2$26.invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object $result) {
        String status;
        boolean isAnime;
        StreamPlay.LinkData res = (StreamPlay.LinkData) this.L$0;
        Function1<? super ExtractorLink, Unit> function1 = (Function1) this.L$1;
        String token = (String) this.L$2;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (this.label) {
            case 0:
                ResultKt.throwOnFailure($result);
                String status2 = ProvidersListKt.getDubStatus(res);
                boolean isAnime2 = res.isAnime();
                if (isAnime2 && !Intrinsics.areEqual(status2, "SUB")) {
                    return Unit.INSTANCE;
                }
                if (res.getImdbId() != null) {
                    if (token.length() > 0) {
                        this.L$0 = SpillingKt.nullOutSpilledVariable(res);
                        this.L$1 = SpillingKt.nullOutSpilledVariable(function1);
                        this.L$2 = SpillingKt.nullOutSpilledVariable(token);
                        this.L$3 = SpillingKt.nullOutSpilledVariable(status2);
                        this.Z$0 = isAnime2;
                        this.label = 1;
                        if (StreamPlayExtractor.INSTANCE.invokeSuperstream(token, res.getImdbId(), res.getId(), res.getSeason(), res.getEpisode(), function1, (Continuation) this) == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                        status = status2;
                        isAnime = isAnime2;
                    }
                }
                return Unit.INSTANCE;
            case 1:
                isAnime = this.Z$0;
                status = (String) this.L$3;
                ResultKt.throwOnFailure($result);
                return Unit.INSTANCE;
            default:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }
}
