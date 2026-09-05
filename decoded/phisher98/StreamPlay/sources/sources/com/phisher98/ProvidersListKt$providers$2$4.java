package com.phisher98;

import com.lagradost.cloudstream3.SubtitleFile;
import com.lagradost.cloudstream3.utils.ExtractorLink;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SpillingKt;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function6;
import kotlin.jvm.internal.SourceDebugExtension;

/* JADX INFO: compiled from: ProvidersList.kt */
/* JADX INFO: loaded from: /home/ubuntu/work/NepaliStream-CNC-Repo/decoded/phisher98/StreamPlay/classes.dex */
@Metadata(d1 = {"\u0000\"\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0012\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00010\u00052\u0012\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\u00010\u00052\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\t\u001a\u00020\nH\n"}, d2 = {"<anonymous>", "", "res", "Lcom/phisher98/StreamPlay$LinkData;", "subtitleCallback", "Lkotlin/Function1;", "Lcom/lagradost/cloudstream3/SubtitleFile;", "callback", "Lcom/lagradost/cloudstream3/utils/ExtractorLink;", "<unused var>", ""}, k = 3, mv = {2, 4, 0}, xi = 48)
@DebugMetadata(c = "com.phisher98.ProvidersListKt$providers$2$4", f = "ProvidersList.kt", i = {0, 0, 0, 1, 1, 1, 1, 1}, l = {140, 141}, m = "invokeSuspend", n = {"res", "subtitleCallback", "callback", "res", "subtitleCallback", "callback", "ids", "it"}, nl = {141, 141}, s = {"L$0", "L$1", "L$2", "L$0", "L$1", "L$2", "L$3", "I$0"}, v = 2)
@SourceDebugExtension({"SMAP\nProvidersList.kt\nKotlin\n*S Kotlin\n*F\n+ 1 ProvidersList.kt\ncom/phisher98/ProvidersListKt$providers$2$4\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,353:1\n1#2:354\n*E\n"})
final class ProvidersListKt$providers$2$4 extends SuspendLambda implements Function6<StreamPlay.LinkData, Function1<? super SubtitleFile, ? extends Unit>, Function1<? super ExtractorLink, ? extends Unit>, String, String, Continuation<? super Unit>, Object> {
    int I$0;
    /* synthetic */ Object L$0;
    /* synthetic */ Object L$1;
    /* synthetic */ Object L$2;
    Object L$3;
    int label;

    ProvidersListKt$providers$2$4(Continuation<? super ProvidersListKt$providers$2$4> continuation) {
        super(6, continuation);
    }

    public final Object invoke(StreamPlay.LinkData linkData, Function1<? super SubtitleFile, Unit> function1, Function1<? super ExtractorLink, Unit> function2, String str, String str2, Continuation<? super Unit> continuation) {
        ProvidersListKt$providers$2$4 providersListKt$providers$2$4 = new ProvidersListKt$providers$2$4(continuation);
        providersListKt$providers$2$4.L$0 = linkData;
        providersListKt$providers$2$4.L$1 = function1;
        providersListKt$providers$2$4.L$2 = function2;
        return providersListKt$providers$2$4.invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Code duplicated, block: B:15:0x0054  */
    /* JADX WARN: Code duplicated, block: B:17:0x008d A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:18:0x008e  */
    public final Object invokeSuspend(Object $result) {
        Object animeIds;
        StreamPlayExtractor.AnimeResolvedIds ids;
        Integer anilistId;
        StreamPlayExtractor streamPlayExtractor;
        Integer numBoxInt;
        Integer episode;
        String dubStatus;
        StreamPlay.LinkData res = (StreamPlay.LinkData) this.L$0;
        Function1<? super SubtitleFile, Unit> function1 = (Function1) this.L$1;
        Function1<? super ExtractorLink, Unit> function2 = (Function1) this.L$2;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (this.label) {
            case 0:
                ResultKt.throwOnFailure($result);
                if (res.isAnime()) {
                    this.L$0 = res;
                    this.L$1 = function1;
                    this.L$2 = function2;
                    this.label = 1;
                    animeIds = ProvidersListKt.getAnimeIds(res, (Continuation) this);
                    if (animeIds == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    ids = (StreamPlayExtractor.AnimeResolvedIds) animeIds;
                    anilistId = ids.getAnilistId();
                    if (anilistId != null) {
                        int it = anilistId.intValue();
                        streamPlayExtractor = StreamPlayExtractor.INSTANCE;
                        numBoxInt = Boxing.boxInt(it);
                        episode = res.getEpisode();
                        dubStatus = ProvidersListKt.getDubStatus(res);
                        this.L$0 = SpillingKt.nullOutSpilledVariable(res);
                        this.L$1 = SpillingKt.nullOutSpilledVariable(function1);
                        this.L$2 = SpillingKt.nullOutSpilledVariable(function2);
                        this.L$3 = SpillingKt.nullOutSpilledVariable(ids);
                        this.I$0 = it;
                        this.label = 2;
                        if (streamPlayExtractor.invokeReAnime(numBoxInt, episode, function1, function2, dubStatus, this) == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                    }
                }
                return Unit.INSTANCE;
            case 1:
                ResultKt.throwOnFailure($result);
                animeIds = $result;
                ids = (StreamPlayExtractor.AnimeResolvedIds) animeIds;
                anilistId = ids.getAnilistId();
                if (anilistId != null) {
                    int it2 = anilistId.intValue();
                    streamPlayExtractor = StreamPlayExtractor.INSTANCE;
                    numBoxInt = Boxing.boxInt(it2);
                    episode = res.getEpisode();
                    dubStatus = ProvidersListKt.getDubStatus(res);
                    this.L$0 = SpillingKt.nullOutSpilledVariable(res);
                    this.L$1 = SpillingKt.nullOutSpilledVariable(function1);
                    this.L$2 = SpillingKt.nullOutSpilledVariable(function2);
                    this.L$3 = SpillingKt.nullOutSpilledVariable(ids);
                    this.I$0 = it2;
                    this.label = 2;
                    if (streamPlayExtractor.invokeReAnime(numBoxInt, episode, function1, function2, dubStatus, this) == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                }
                return Unit.INSTANCE;
            case 2:
                int i = this.I$0;
                ResultKt.throwOnFailure($result);
                return Unit.INSTANCE;
            default:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }
}
