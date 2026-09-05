package com.phisher98;

import com.google.gson.Gson;
import com.lagradost.cloudstream3.Episode;
import com.lagradost.cloudstream3.MainAPIKt;
import com.lagradost.cloudstream3.Score;
import com.lagradost.cloudstream3.utils.AppUtils;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.text.StringsKt;

/* JADX INFO: compiled from: ShowBox.kt */
/* JADX INFO: loaded from: /home/ubuntu/work/NepaliStream-CNC-Repo/decoded/phisher98/ShowBox/classes.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u00012\u0006\u0010\u0003\u001a\u00020\u0004H\n"}, d2 = {"<anonymous>", "", "Lcom/lagradost/cloudstream3/Episode;", "seasonNumber", ""}, k = 3, mv = {2, 4, 0}, xi = 48)
@DebugMetadata(c = "com.phisher98.ShowBox$load$allEpisodes$1", f = "ShowBox.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, nl = {}, s = {}, v = 2)
@SourceDebugExtension({"SMAP\nShowBox.kt\nKotlin\n*S Kotlin\n*F\n+ 1 ShowBox.kt\ncom/phisher98/ShowBox$load$allEpisodes$1\n+ 2 ShowBox.kt\ncom/phisher98/ShowBox\n+ 3 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n+ 4 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,946:1\n365#2,12:947\n1739#3:959\n1814#3,3:960\n1#4:963\n*S KotlinDebug\n*F\n+ 1 ShowBox.kt\ncom/phisher98/ShowBox$load$allEpisodes$1\n*L\n715#1:947,12\n719#1:959\n719#1:960,3\n*E\n"})
final class ShowBox$load$allEpisodes$1 extends SuspendLambda implements Function2<Integer, Continuation<? super List<? extends Episode>>, Object> {
    final /* synthetic */ ShowBox.SeriesData $data;
    final /* synthetic */ int $hideNsfw;
    final /* synthetic */ ShowBox.LoadData $loadData;
    /* synthetic */ int I$0;
    int label;
    final /* synthetic */ ShowBox this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    ShowBox$load$allEpisodes$1(ShowBox showBox, int i, ShowBox.LoadData loadData, ShowBox.SeriesData seriesData, Continuation<? super ShowBox$load$allEpisodes$1> continuation) {
        super(2, continuation);
        this.this$0 = showBox;
        this.$hideNsfw = i;
        this.$loadData = loadData;
        this.$data = seriesData;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        Continuation<Unit> showBox$load$allEpisodes$1 = new ShowBox$load$allEpisodes$1(this.this$0, this.$hideNsfw, this.$loadData, this.$data, continuation);
        showBox$load$allEpisodes$1.I$0 = ((Number) obj).intValue();
        return showBox$load$allEpisodes$1;
    }

    public final Object invoke(int i, Continuation<? super List<Episode>> continuation) {
        return create(Integer.valueOf(i), continuation).invokeSuspend(Unit.INSTANCE);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
        return invoke(((Number) obj).intValue(), (Continuation<? super List<Episode>>) obj2);
    }

    public final Object invokeSuspend(Object $result) {
        Object objFromJson;
        int seasonNumber = this.I$0;
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (this.label) {
            case 0:
                ResultKt.throwOnFailure($result);
                ShowBox this_$iv = this.this$0;
                String query$iv = "{\"childmode\":\"" + this.$hideNsfw + "\",\"uid\":\"\",\"app_version\":\"" + this.this$0.appVersion + "\",\"appid\":\"" + this.this$0.appIdSecond + "\",\"module\":\"TV_episode\",\"display_all\":\"1\",\"season\":\"" + seasonNumber + "\",\"channel\":\"Website\",\"lang\":\"en\",\"expired_date\":\"" + this.this$0.getExpiryDate() + "\",\"platform\":\"android\",\"tid\":\"" + this.$loadData.getId() + "\"}";
                Gson gson$iv = new Gson();
                String json$iv = this_$iv.queryApi(query$iv, false);
                if (StringsKt.isBlank(json$iv) || StringsKt.startsWith$default(StringsKt.trim(json$iv).toString(), "<", false, 2, (Object) null)) {
                    String jsonAlt$iv = this_$iv.queryApi(query$iv, true);
                    objFromJson = gson$iv.fromJson(jsonAlt$iv, ShowBox.SeriesSeasonProp.class);
                } else {
                    try {
                        objFromJson = gson$iv.fromJson(json$iv, ShowBox.SeriesSeasonProp.class);
                    } catch (Exception e) {
                        String jsonAlt$iv2 = this_$iv.queryApi(query$iv, true);
                        objFromJson = gson$iv.fromJson(jsonAlt$iv2, ShowBox.SeriesSeasonProp.class);
                    }
                    break;
                }
                List seasonData = ((ShowBox.SeriesSeasonProp) objFromJson).getData();
                List $this$map$iv = seasonData;
                ShowBox showBox = this.this$0;
                ShowBox.SeriesData seriesData = this.$data;
                Collection destination$iv$iv = new ArrayList(CollectionsKt.collectionSizeOrDefault($this$map$iv, 10));
                for (Object item$iv$iv : $this$map$iv) {
                    final ShowBox.SeriesEpisode ep = (ShowBox.SeriesEpisode) item$iv$iv;
                    ShowBox showBox2 = showBox;
                    AppUtils appUtils = AppUtils.INSTANCE;
                    Integer tid = ep.getTid();
                    if (tid == null && (tid = ep.getId()) == null) {
                        throw new RuntimeException("No Series ID");
                    }
                    destination$iv$iv.add(MainAPIKt.newEpisode(showBox2, appUtils.toJson(new ShowBox.LinkData(tid.intValue(), ShowBox.ResponseTypes.Series.getValue(), ep.getSeason(), ep.getEpisode(), seriesData.getId(), seriesData.getImdbId())), new Function1() { // from class: com.phisher98.ShowBox$load$allEpisodes$1$$ExternalSyntheticLambda0
                        public final Object invoke(Object obj) {
                            return ShowBox$load$allEpisodes$1.invokeSuspend$lambda$0$0(ep, (Episode) obj);
                        }
                    }));
                    seasonData = seasonData;
                }
                return (List) destination$iv$iv;
            default:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code duplicated, block: B:9:0x0016  */
    public static final Unit invokeSuspend$lambda$0$0(ShowBox.SeriesEpisode $ep, Episode $this$newEpisode) {
        Float floatOrNull;
        String it = $ep.getTitle();
        if (it == null) {
            it = "Episode " + $ep.getEpisode();
        } else {
            if (StringsKt.isBlank(it)) {
                it = null;
            }
            if (it == null) {
                it = "Episode " + $ep.getEpisode();
            }
        }
        $this$newEpisode.setName(it);
        $this$newEpisode.setSeason($ep.getSeason());
        $this$newEpisode.setEpisode($ep.getEpisode());
        String thumbsOriginal = $ep.getThumbsOriginal();
        if (thumbsOriginal == null && (thumbsOriginal = $ep.getThumbsBak()) == null && (thumbsOriginal = $ep.getThumbsMin()) == null && (thumbsOriginal = $ep.getThumbs()) == null) {
            thumbsOriginal = $ep.getThumbsOrg();
        }
        $this$newEpisode.setPosterUrl(thumbsOriginal);
        $this$newEpisode.setDescription($ep.getSynopsis());
        $this$newEpisode.setRunTime($ep.getRuntime());
        String imdbRating = $ep.getImdbRating();
        $this$newEpisode.setScore((imdbRating == null || (floatOrNull = StringsKt.toFloatOrNull(imdbRating)) == null) ? null : Score.Companion.from10(Float.valueOf(floatOrNull.floatValue())));
        String released = $ep.getReleased();
        MainAPIKt.addDate($this$newEpisode, released != null ? StringsKt.substringBefore$default(released, " (", (String) null, 2, (Object) null) : null, "MMMM d, yyyy");
        return Unit.INSTANCE;
    }
}
