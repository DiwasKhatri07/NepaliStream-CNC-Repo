package com.Kartoons;

import com.lagradost.nicehttp.NiceResponse;
import com.lagradost.nicehttp.ResponseParser;
import java.util.List;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SpillingKt;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: compiled from: Kartoons.kt */
/* JADX INFO: loaded from: /home/ubuntu/work/NepaliStream-CNC-Repo/decoded/phisher98/Kartoons/classes.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u0004\u0018\u00010\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "Lcom/Kartoons/SeasonEpisodes;", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 4, 0}, xi = 48)
@DebugMetadata(c = "com.Kartoons.Kartoons$fetchSeasonDetailsForShow$2$1$1", f = "Kartoons.kt", i = {0}, l = {508}, m = "invokeSuspend", n = {"seasonUrl"}, nl = {509}, s = {"L$0"}, v = 2)
@SourceDebugExtension({"SMAP\nKartoons.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Kartoons.kt\ncom/Kartoons/Kartoons$fetchSeasonDetailsForShow$2$1$1\n+ 2 NiceResponse.kt\ncom/lagradost/nicehttp/NiceResponse\n*L\n1#1,527:1\n104#2,5:528\n*S KotlinDebug\n*F\n+ 1 Kartoons.kt\ncom/Kartoons/Kartoons$fetchSeasonDetailsForShow$2$1$1\n*L\n509#1:528,5\n*E\n"})
final class Kartoons$fetchSeasonDetailsForShow$2$1$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super SeasonEpisodes>, Object> {
    final /* synthetic */ String $mainUrl;
    final /* synthetic */ String $seasonSlug;
    final /* synthetic */ String $showSlug;
    Object L$0;
    int label;
    final /* synthetic */ Kartoons this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    Kartoons$fetchSeasonDetailsForShow$2$1$1(String str, String str2, String str3, Kartoons kartoons, Continuation<? super Kartoons$fetchSeasonDetailsForShow$2$1$1> continuation) {
        super(2, continuation);
        this.$mainUrl = str;
        this.$showSlug = str2;
        this.$seasonSlug = str3;
        this.this$0 = kartoons;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new Kartoons$fetchSeasonDetailsForShow$2$1$1(this.$mainUrl, this.$showSlug, this.$seasonSlug, this.this$0, continuation);
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super SeasonEpisodes> continuation) {
        return create(coroutineScope, continuation).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object $result) {
        Object objAppGet$default;
        Object safe;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (this.label) {
            case 0:
                ResultKt.throwOnFailure($result);
                String seasonUrl = this.$mainUrl + "/api/shows/" + this.$showSlug + "/season/" + this.$seasonSlug + "/all-episodes";
                this.L$0 = SpillingKt.nullOutSpilledVariable(seasonUrl);
                this.label = 1;
                objAppGet$default = Kartoons.appGet$default(this.this$0, seasonUrl, null, (Continuation) this, 2, null);
                if (objAppGet$default == coroutine_suspended) {
                    return coroutine_suspended;
                }
                break;
            case 1:
                ResultKt.throwOnFailure($result);
                objAppGet$default = $result;
                break;
            default:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        NiceResponse this_$iv = (NiceResponse) objAppGet$default;
        try {
            ResponseParser parser = this_$iv.getParser();
            Intrinsics.checkNotNull(parser);
            safe = parser.parseSafe(this_$iv.getTextLarge(), Reflection.getOrCreateKotlinClass(EpisodesRoot.class));
        } catch (Exception e$iv) {
            e$iv.printStackTrace();
            safe = null;
        }
        EpisodesRoot root = (EpisodesRoot) safe;
        if (root != null) {
            EpisodeSeasonMeta season = root.getSeason();
            Long seasonNumber = season != null ? season.getSeasonNumber() : null;
            List<EpisodeItem> data = root.getData();
            if (data == null) {
                data = CollectionsKt.emptyList();
            }
            return new SeasonEpisodes(seasonNumber, data);
        }
        return null;
    }
}
