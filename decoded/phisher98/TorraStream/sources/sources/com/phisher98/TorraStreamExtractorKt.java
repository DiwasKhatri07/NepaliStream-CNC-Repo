package com.phisher98;

import com.lagradost.cloudstream3.MainAPIKt;
import com.lagradost.cloudstream3.MainActivityKt;
import com.lagradost.cloudstream3.ParCollectionsKt;
import com.lagradost.cloudstream3.SubtitleFile;
import com.lagradost.cloudstream3.TvType;
import com.lagradost.cloudstream3.utils.ExtractorApiKt;
import com.lagradost.cloudstream3.utils.ExtractorLink;
import com.lagradost.nicehttp.NiceResponse;
import com.lagradost.nicehttp.Requests;
import com.lagradost.nicehttp.ResponseParser;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SpillingKt;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.jvm.internal.StringCompanionObject;
import kotlin.sequences.SequencesKt;
import kotlin.text.CharsKt;
import kotlin.text.MatchResult;
import kotlin.text.Regex;
import kotlin.text.RegexOption;
import kotlin.text.StringsKt;
import okhttp3.Interceptor;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.jsoup.nodes.Element;

/* JADX INFO: compiled from: TorraStreamExtractor.kt */
/* JADX INFO: loaded from: /home/ubuntu/work/NepaliStream-CNC-Repo/decoded/phisher98/TorraStream/classes.dex */
@Metadata(d1 = {"\u0000<\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0010\u000b\n\u0002\b\u0006\u001aN\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00062\u0012\u0010\b\u001a\u000e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u00010\tH\u0086@¢\u0006\u0002\u0010\u000b\u001aN\u0010\f\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00062\u0012\u0010\b\u001a\u000e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u00010\tH\u0086@¢\u0006\u0002\u0010\u000b\u001aJ\u0010\r\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u000e\u001a\u00020\u000f2\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00062\u0012\u0010\b\u001a\u000e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u00010\tH\u0086@¢\u0006\u0002\u0010\u0010\u001aJ\u0010\u0011\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u000e\u001a\u00020\u000f2\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00062\u0012\u0010\u0012\u001a\u000e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u00010\tH\u0086@¢\u0006\u0002\u0010\u0010\u001aR\u0010\u0013\u001a\u00020\u00012\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00062\u0012\u0010\u0012\u001a\u000e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u00010\tH\u0086@¢\u0006\u0002\u0010\u000b\u001aF\u0010\u0016\u001a\u00020\u00012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00062\u0012\u0010\u0017\u001a\u000e\u0012\u0004\u0012\u00020\u0018\u0012\u0004\u0012\u00020\u00010\tH\u0086@¢\u0006\u0002\u0010\u0019\u001a,\u0010\u001a\u001a\u00020\u00012\b\u0010\u0004\u001a\u0004\u0018\u00010\u00062\u0012\u0010\u0012\u001a\u000e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u00010\tH\u0086@¢\u0006\u0002\u0010\u001b\u001aN\u0010\u001c\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00062\u0012\u0010\b\u001a\u000e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u00010\tH\u0086@¢\u0006\u0002\u0010\u001d\u001aN\u0010\u001e\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00062\u0012\u0010\b\u001a\u000e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u00010\tH\u0086@¢\u0006\u0002\u0010\u000b\u001aZ\u0010\u001f\u001a\u00020\u00012\u0006\u0010 \u001a\u00020\u00032\n\b\u0002\u0010!\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\"\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00062\u0012\u0010\b\u001a\u000e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u00010\tH\u0086@¢\u0006\u0002\u0010#\u001ab\u0010$\u001a\u00020\u00012\u0006\u0010%\u001a\u00020\u00032\u0006\u0010&\u001a\u00020'2\n\b\u0002\u0010!\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\"\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00062\u0012\u0010\b\u001a\u000e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u00010\tH\u0086@¢\u0006\u0002\u0010(\u001aN\u0010)\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00062\u0012\u0010\u0012\u001a\u000e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u00010\tH\u0086@¢\u0006\u0002\u0010\u000b\u001aN\u0010*\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00062\u0012\u0010\b\u001a\u000e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u00010\tH\u0086@¢\u0006\u0002\u0010\u001d\u001aN\u0010+\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00062\u0012\u0010\b\u001a\u000e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u00010\tH\u0086@¢\u0006\u0002\u0010\u000b\u001aJ\u0010,\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u000e\u001a\u00020\u000f2\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00062\u0012\u0010\b\u001a\u000e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u00010\tH\u0086@¢\u0006\u0002\u0010\u0010¨\u0006-"}, d2 = {"invokeTorrentio", "", "mainUrl", "", "id", "season", "", "episode", "filtered", "Lkotlin/Function1;", "Lcom/lagradost/cloudstream3/utils/ExtractorLink;", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/Integer;Lkotlin/jvm/functions/Function1;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "invokeTorrentioDebian", "invokeTorrentioAnimeDebian", "type", "Lcom/lagradost/cloudstream3/TvType;", "(Ljava/lang/String;Lcom/lagradost/cloudstream3/TvType;Ljava/lang/Integer;Ljava/lang/Integer;Lkotlin/jvm/functions/Function1;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "invokeTorrentioAnimeType", "callback", "invokeThepiratebay", "thepiratebayApi", "imdbId", "invokeSubtitleAPI", "subtitleCallback", "Lcom/lagradost/cloudstream3/SubtitleFile;", "(Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/Integer;Lkotlin/jvm/functions/Function1;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "invokeAnimetosho", "(Ljava/lang/Integer;Lkotlin/jvm/functions/Function1;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "invokeTorrentioAnime", "(Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;Lkotlin/jvm/functions/Function1;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "invokeAIOStreamsDebian", "invokeUindex", "uindex", "title", "year", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;Lkotlin/jvm/functions/Function1;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "invokeKnaben", "knaben", "isAnime", "", "(Ljava/lang/String;ZLjava/lang/String;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;Lkotlin/jvm/functions/Function1;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "invokeTorrentsDB", "invokeTorrentsDBAnime", "invokeMeteorDebian", "invokeMeteorAnimeDebian", "TorraStream"}, k = 2, mv = {2, 4, 0}, xi = 48)
@SourceDebugExtension({"SMAP\nTorraStreamExtractor.kt\nKotlin\n*S Kotlin\n*F\n+ 1 TorraStreamExtractor.kt\ncom/phisher98/TorraStreamExtractorKt\n+ 2 NiceResponse.kt\ncom/lagradost/nicehttp/NiceResponse\n+ 3 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n+ 4 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,823:1\n73#2,5:824\n73#2,5:831\n73#2,5:839\n73#2,5:846\n73#2,5:853\n73#2,5:858\n73#2,5:863\n73#2,5:871\n73#2,5:878\n73#2,5:891\n73#2,5:896\n73#2,5:901\n73#2,5:908\n2068#3,2:829\n2068#3:836\n2069#3:838\n2068#3,2:844\n2068#3,2:851\n1233#3:868\n2068#3,2:869\n2068#3,2:876\n2068#3,2:883\n1739#3:885\n1814#3,3:886\n2068#3,2:889\n2068#3,2:906\n2068#3,2:913\n1#4:837\n*S KotlinDebug\n*F\n+ 1 TorraStreamExtractor.kt\ncom/phisher98/TorraStreamExtractorKt\n*L\n35#1:824,5\n83#1:831,5\n135#1:839,5\n192#1:846,5\n241#1:853,5\n275#1:858,5\n294#1:863,5\n346#1:871,5\n389#1:878,5\n626#1:891,5\n675#1:896,5\n716#1:901,5\n779#1:908,5\n36#1:829,2\n84#1:836\n84#1:838\n136#1:844,2\n193#1:851,2\n300#1:868\n301#1:869,2\n347#1:876,2\n396#1:883,2\n454#1:885\n454#1:886,3\n552#1:889,2\n718#1:906,2\n781#1:913,2\n*E\n"})
public final class TorraStreamExtractorKt {

    /* JADX INFO: renamed from: com.phisher98.TorraStreamExtractorKt$invokeAIOStreamsDebian$1 */
    /* JADX INFO: compiled from: TorraStreamExtractor.kt */
    @Metadata(k = 3, mv = {2, 4, 0}, xi = 48)
    @DebugMetadata(c = "com.phisher98.TorraStreamExtractorKt", f = "TorraStreamExtractor.kt", i = {0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1}, l = {389, 405}, m = "invokeAIOStreamsDebian", n = {"mainUrl", "id", "season", "episode", "filtered", "base", "url", "mainUrl", "id", "season", "episode", "filtered", "base", "url", "res", "qualityRegex", "$this$forEach$iv", "element$iv", "stream", "nameSource", "streamUrl", "qualityMatch", "linkName", "quality"}, nl = {824, 415}, s = {"L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$6", "L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$6", "L$7", "L$8", "L$9", "L$11", "L$12", "L$13", "L$14", "L$15", "L$16", "I$0"}, v = 2)
    static final class C00351 extends ContinuationImpl {
        int I$0;
        Object L$0;
        Object L$1;
        Object L$10;
        Object L$11;
        Object L$12;
        Object L$13;
        Object L$14;
        Object L$15;
        Object L$16;
        Object L$2;
        Object L$3;
        Object L$4;
        Object L$5;
        Object L$6;
        Object L$7;
        Object L$8;
        Object L$9;
        int label;
        /* synthetic */ Object result;

        C00351(Continuation<? super C00351> continuation) {
            super(continuation);
        }

        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return TorraStreamExtractorKt.invokeAIOStreamsDebian(null, null, null, null, null, (Continuation) this);
        }
    }

    /* JADX INFO: renamed from: com.phisher98.TorraStreamExtractorKt$invokeAnimetosho$1 */
    /* JADX INFO: compiled from: TorraStreamExtractor.kt */
    @Metadata(k = 3, mv = {2, 4, 0}, xi = 48)
    @DebugMetadata(c = "com.phisher98.TorraStreamExtractorKt", f = "TorraStreamExtractor.kt", i = {0, 0, 0, 1, 1, 1, 1, 1, 1, 1, 1, 1}, l = {293, 314}, m = "invokeAnimetosho", n = {"id", "callback", "url", "id", "callback", "url", "response", "$this$forEach$iv", "element$iv", "item", "tags", "displayName"}, nl = {294, 313}, s = {"L$0", "L$1", "L$2", "L$0", "L$1", "L$2", "L$3", "L$4", "L$6", "L$7", "L$8", "L$9"}, v = 2)
    static final class C00371 extends ContinuationImpl {
        Object L$0;
        Object L$1;
        Object L$10;
        Object L$2;
        Object L$3;
        Object L$4;
        Object L$5;
        Object L$6;
        Object L$7;
        Object L$8;
        Object L$9;
        int label;
        /* synthetic */ Object result;

        C00371(Continuation<? super C00371> continuation) {
            super(continuation);
        }

        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return TorraStreamExtractorKt.invokeAnimetosho(null, null, (Continuation) this);
        }
    }

    /* JADX INFO: renamed from: com.phisher98.TorraStreamExtractorKt$invokeKnaben$1 */
    /* JADX INFO: compiled from: TorraStreamExtractor.kt */
    @Metadata(k = 3, mv = {2, 4, 0}, xi = 48)
    @DebugMetadata(c = "com.phisher98.TorraStreamExtractorKt", f = "TorraStreamExtractor.kt", i = {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1}, l = {550, 595}, m = "invokeKnaben", n = {"knaben", "title", "year", "season", "episode", "filtered", "host", "baseQuery", "category", "url", "isAnime", "isTv", "page", "knaben", "title", "year", "season", "episode", "filtered", "host", "baseQuery", "category", "url", "doc", "$this$forEach$iv", "element$iv", "row", "titleElement", "infoTd", "rawTitle", "magnet", "source", "tds", "sizeText", "seedsText", "qualityMatch", "formattedTitleName", "isAnime", "isTv", "page", "seeds"}, nl = {552, 594}, s = {"L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$6", "L$7", "L$8", "L$9", "Z$0", "I$0", "I$1", "L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$6", "L$7", "L$8", "L$9", "L$10", "L$11", "L$13", "L$14", "L$15", "L$16", "L$17", "L$18", "L$19", "L$20", "L$21", "L$22", "L$23", "L$24", "Z$0", "I$0", "I$1", "I$2"}, v = 2)
    static final class C00381 extends ContinuationImpl {
        int I$0;
        int I$1;
        int I$2;
        Object L$0;
        Object L$1;
        Object L$10;
        Object L$11;
        Object L$12;
        Object L$13;
        Object L$14;
        Object L$15;
        Object L$16;
        Object L$17;
        Object L$18;
        Object L$19;
        Object L$2;
        Object L$20;
        Object L$21;
        Object L$22;
        Object L$23;
        Object L$24;
        Object L$25;
        Object L$3;
        Object L$4;
        Object L$5;
        Object L$6;
        Object L$7;
        Object L$8;
        Object L$9;
        boolean Z$0;
        int label;
        /* synthetic */ Object result;

        C00381(Continuation<? super C00381> continuation) {
            super(continuation);
        }

        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return TorraStreamExtractorKt.invokeKnaben(null, false, null, null, null, null, null, (Continuation) this);
        }
    }

    /* JADX INFO: renamed from: com.phisher98.TorraStreamExtractorKt$invokeMeteorAnimeDebian$1 */
    /* JADX INFO: compiled from: TorraStreamExtractor.kt */
    @Metadata(k = 3, mv = {2, 4, 0}, xi = 48)
    @DebugMetadata(c = "com.phisher98.TorraStreamExtractorKt", f = "TorraStreamExtractor.kt", i = {0, 0, 0, 0, 0, 0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1}, l = {779, 812}, m = "invokeMeteorAnimeDebian", n = {"mainUrl", "type", "id", "episode", "filtered", "url", "mainUrl", "type", "id", "episode", "filtered", "url", "res", "$this$forEach$iv", "element$iv", "stream", "fileUrl", "name", "formattedName", "cache", "parts", "suffix", "size", "audio", "resolution", "finalTitle"}, nl = {824, 811}, s = {"L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$6", "L$7", "L$9", "L$10", "L$11", "L$12", "L$13", "L$14", "L$15", "L$16", "L$17", "L$18", "L$19", "L$20"}, v = 2)
    static final class C00391 extends ContinuationImpl {
        Object L$0;
        Object L$1;
        Object L$10;
        Object L$11;
        Object L$12;
        Object L$13;
        Object L$14;
        Object L$15;
        Object L$16;
        Object L$17;
        Object L$18;
        Object L$19;
        Object L$2;
        Object L$20;
        Object L$21;
        Object L$3;
        Object L$4;
        Object L$5;
        Object L$6;
        Object L$7;
        Object L$8;
        Object L$9;
        int label;
        /* synthetic */ Object result;

        C00391(Continuation<? super C00391> continuation) {
            super(continuation);
        }

        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return TorraStreamExtractorKt.invokeMeteorAnimeDebian(null, null, null, null, null, (Continuation) this);
        }
    }

    /* JADX INFO: renamed from: com.phisher98.TorraStreamExtractorKt$invokeMeteorDebian$1 */
    /* JADX INFO: compiled from: TorraStreamExtractor.kt */
    @Metadata(k = 3, mv = {2, 4, 0}, xi = 48)
    @DebugMetadata(c = "com.phisher98.TorraStreamExtractorKt", f = "TorraStreamExtractor.kt", i = {0, 0, 0, 0, 0, 0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1}, l = {716, 752}, m = "invokeMeteorDebian", n = {"mainUrl", "id", "season", "episode", "filtered", "url", "mainUrl", "id", "season", "episode", "filtered", "url", "res", "$this$forEach$iv", "element$iv", "stream", "fileUrl", "name", "formattedName", "parts", "cache", "suffix", "size", "audio", "resolution", "finalTitle"}, nl = {824, 751}, s = {"L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$6", "L$7", "L$9", "L$10", "L$11", "L$12", "L$13", "L$14", "L$15", "L$16", "L$17", "L$18", "L$19", "L$20"}, v = 2)
    static final class C00401 extends ContinuationImpl {
        Object L$0;
        Object L$1;
        Object L$10;
        Object L$11;
        Object L$12;
        Object L$13;
        Object L$14;
        Object L$15;
        Object L$16;
        Object L$17;
        Object L$18;
        Object L$19;
        Object L$2;
        Object L$20;
        Object L$21;
        Object L$3;
        Object L$4;
        Object L$5;
        Object L$6;
        Object L$7;
        Object L$8;
        Object L$9;
        int label;
        /* synthetic */ Object result;

        C00401(Continuation<? super C00401> continuation) {
            super(continuation);
        }

        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return TorraStreamExtractorKt.invokeMeteorDebian(null, null, null, null, null, (Continuation) this);
        }
    }

    /* JADX INFO: renamed from: com.phisher98.TorraStreamExtractorKt$invokeSubtitleAPI$1 */
    /* JADX INFO: compiled from: TorraStreamExtractor.kt */
    @Metadata(k = 3, mv = {2, 4, 0}, xi = 48)
    @DebugMetadata(c = "com.phisher98.TorraStreamExtractorKt", f = "TorraStreamExtractor.kt", i = {0, 0, 0, 0, 0, 0, 1, 1, 1, 1, 1, 1}, l = {274, 275}, m = "invokeSubtitleAPI", n = {"id", "season", "episode", "subtitleCallback", "url", "headers", "id", "season", "episode", "subtitleCallback", "url", "headers"}, nl = {275, 285}, s = {"L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$0", "L$1", "L$2", "L$3", "L$4", "L$5"}, v = 2)
    static final class C00411 extends ContinuationImpl {
        Object L$0;
        Object L$1;
        Object L$2;
        Object L$3;
        Object L$4;
        Object L$5;
        int label;
        /* synthetic */ Object result;

        C00411(Continuation<? super C00411> continuation) {
            super(continuation);
        }

        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return TorraStreamExtractorKt.invokeSubtitleAPI(null, null, null, null, (Continuation) this);
        }
    }

    /* JADX INFO: renamed from: com.phisher98.TorraStreamExtractorKt$invokeThepiratebay$1 */
    /* JADX INFO: compiled from: TorraStreamExtractor.kt */
    @Metadata(k = 3, mv = {2, 4, 0}, xi = 48)
    @DebugMetadata(c = "com.phisher98.TorraStreamExtractorKt", f = "TorraStreamExtractor.kt", i = {0, 0, 0, 0, 0, 0, 1, 1, 1, 1, 1, 1, 1, 1, 2, 2, 2, 2, 2, 2, 2, 2, 2}, l = {241, 244, 246}, m = "invokeThepiratebay", n = {"thepiratebayApi", "imdbId", "season", "episode", "callback", "url", "thepiratebayApi", "imdbId", "season", "episode", "callback", "url", "res", "stream", "thepiratebayApi", "imdbId", "season", "episode", "callback", "url", "res", "stream", "magnetLink"}, nl = {824, 244, 245}, s = {"L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$6", "L$8", "L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$6", "L$8", "L$9"}, v = 2)
    static final class C00431 extends ContinuationImpl {
        Object L$0;
        Object L$1;
        Object L$10;
        Object L$2;
        Object L$3;
        Object L$4;
        Object L$5;
        Object L$6;
        Object L$7;
        Object L$8;
        Object L$9;
        int label;
        /* synthetic */ Object result;

        C00431(Continuation<? super C00431> continuation) {
            super(continuation);
        }

        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return TorraStreamExtractorKt.invokeThepiratebay(null, null, null, null, null, (Continuation) this);
        }
    }

    /* JADX INFO: renamed from: com.phisher98.TorraStreamExtractorKt$invokeTorrentio$1 */
    /* JADX INFO: compiled from: TorraStreamExtractor.kt */
    @Metadata(k = 3, mv = {2, 4, 0}, xi = 48)
    @DebugMetadata(c = "com.phisher98.TorraStreamExtractorKt", f = "TorraStreamExtractor.kt", i = {0, 0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2}, l = {35, 54, 57}, m = "invokeTorrentio", n = {"mainUrl", "id", "season", "episode", "filtered", "torrentioAPI", "url", "headers", "mainUrl", "id", "season", "episode", "filtered", "torrentioAPI", "url", "headers", "res", "$this$forEach$iv", "element$iv", "stream", "qualityMatch", "formattedTitleName", "mainUrl", "id", "season", "episode", "filtered", "torrentioAPI", "url", "headers", "res", "$this$forEach$iv", "element$iv", "stream", "qualityMatch", "magnet", "formattedTitleName"}, nl = {824, 56, 56}, s = {"L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$6", "L$7", "L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$6", "L$7", "L$8", "L$9", "L$11", "L$12", "L$13", "L$14", "L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$6", "L$7", "L$8", "L$9", "L$11", "L$12", "L$13", "L$14", "L$15"}, v = 2)
    static final class C00451 extends ContinuationImpl {
        Object L$0;
        Object L$1;
        Object L$10;
        Object L$11;
        Object L$12;
        Object L$13;
        Object L$14;
        Object L$15;
        Object L$16;
        Object L$2;
        Object L$3;
        Object L$4;
        Object L$5;
        Object L$6;
        Object L$7;
        Object L$8;
        Object L$9;
        int label;
        /* synthetic */ Object result;

        C00451(Continuation<? super C00451> continuation) {
            super(continuation);
        }

        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return TorraStreamExtractorKt.invokeTorrentio(null, null, null, null, null, (Continuation) this);
        }
    }

    /* JADX INFO: renamed from: com.phisher98.TorraStreamExtractorKt$invokeTorrentioAnime$1 */
    /* JADX INFO: compiled from: TorraStreamExtractor.kt */
    @Metadata(k = 3, mv = {2, 4, 0}, xi = 48)
    @DebugMetadata(c = "com.phisher98.TorraStreamExtractorKt", f = "TorraStreamExtractor.kt", i = {0, 0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2}, l = {346, 348, 360}, m = "invokeTorrentioAnime", n = {"mainUrl", "id", "season", "episode", "filtered", "torrentioAPI", "url", "headers", "mainUrl", "id", "season", "episode", "filtered", "torrentioAPI", "url", "headers", "res", "$this$forEach$iv", "element$iv", "stream", "mainUrl", "id", "season", "episode", "filtered", "torrentioAPI", "url", "headers", "res", "$this$forEach$iv", "element$iv", "stream", "magnet", "formattedTitleName"}, nl = {824, 350, 359}, s = {"L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$6", "L$7", "L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$6", "L$7", "L$8", "L$9", "L$11", "L$12", "L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$6", "L$7", "L$8", "L$9", "L$11", "L$12", "L$13", "L$14"}, v = 2)
    static final class C00461 extends ContinuationImpl {
        Object L$0;
        Object L$1;
        Object L$10;
        Object L$11;
        Object L$12;
        Object L$13;
        Object L$14;
        Object L$15;
        Object L$2;
        Object L$3;
        Object L$4;
        Object L$5;
        Object L$6;
        Object L$7;
        Object L$8;
        Object L$9;
        int label;
        /* synthetic */ Object result;

        C00461(Continuation<? super C00461> continuation) {
            super(continuation);
        }

        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return TorraStreamExtractorKt.invokeTorrentioAnime(null, null, null, null, null, (Continuation) this);
        }
    }

    /* JADX INFO: renamed from: com.phisher98.TorraStreamExtractorKt$invokeTorrentioAnimeDebian$1 */
    /* JADX INFO: compiled from: TorraStreamExtractor.kt */
    @Metadata(k = 3, mv = {2, 4, 0}, xi = 48)
    @DebugMetadata(c = "com.phisher98.TorraStreamExtractorKt", f = "TorraStreamExtractor.kt", i = {0, 0, 0, 0, 0, 0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1}, l = {135, 162}, m = "invokeTorrentioAnimeDebian", n = {"mainUrl", "type", "id", "episode", "filtered", "url", "mainUrl", "type", "id", "episode", "filtered", "url", "res", "$this$forEach$iv", "element$iv", "stream", "fileUrl", "seedersNum", "name", "cache", "formattedName", "size", "parts", "suffix", "finalTitle"}, nl = {824, 161}, s = {"L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$6", "L$7", "L$9", "L$10", "L$11", "L$12", "L$13", "L$14", "L$15", "L$16", "L$17", "L$18", "L$19"}, v = 2)
    static final class C00471 extends ContinuationImpl {
        Object L$0;
        Object L$1;
        Object L$10;
        Object L$11;
        Object L$12;
        Object L$13;
        Object L$14;
        Object L$15;
        Object L$16;
        Object L$17;
        Object L$18;
        Object L$19;
        Object L$2;
        Object L$20;
        Object L$3;
        Object L$4;
        Object L$5;
        Object L$6;
        Object L$7;
        Object L$8;
        Object L$9;
        int label;
        /* synthetic */ Object result;

        C00471(Continuation<? super C00471> continuation) {
            super(continuation);
        }

        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return TorraStreamExtractorKt.invokeTorrentioAnimeDebian(null, null, null, null, null, (Continuation) this);
        }
    }

    /* JADX INFO: renamed from: com.phisher98.TorraStreamExtractorKt$invokeTorrentioAnimeType$1 */
    /* JADX INFO: compiled from: TorraStreamExtractor.kt */
    @Metadata(k = 3, mv = {2, 4, 0}, xi = 48)
    @DebugMetadata(c = "com.phisher98.TorraStreamExtractorKt", f = "TorraStreamExtractor.kt", i = {0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2}, l = {192, 211, 213}, m = "invokeTorrentioAnimeType", n = {"mainUrl", "type", "id", "episode", "callback", "url", "headers", "mainUrl", "type", "id", "episode", "callback", "url", "headers", "res", "$this$forEach$iv", "element$iv", "stream", "qualityMatch", "formattedTitleName", "mainUrl", "type", "id", "episode", "callback", "url", "headers", "res", "$this$forEach$iv", "element$iv", "stream", "qualityMatch", "magnet", "formattedTitleName"}, nl = {824, 212, 212}, s = {"L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$6", "L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$6", "L$7", "L$8", "L$10", "L$11", "L$12", "L$13", "L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$6", "L$7", "L$8", "L$10", "L$11", "L$12", "L$13", "L$14"}, v = 2)
    static final class C00481 extends ContinuationImpl {
        Object L$0;
        Object L$1;
        Object L$10;
        Object L$11;
        Object L$12;
        Object L$13;
        Object L$14;
        Object L$15;
        Object L$2;
        Object L$3;
        Object L$4;
        Object L$5;
        Object L$6;
        Object L$7;
        Object L$8;
        Object L$9;
        int label;
        /* synthetic */ Object result;

        C00481(Continuation<? super C00481> continuation) {
            super(continuation);
        }

        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return TorraStreamExtractorKt.invokeTorrentioAnimeType(null, null, null, null, null, (Continuation) this);
        }
    }

    /* JADX INFO: renamed from: com.phisher98.TorraStreamExtractorKt$invokeTorrentioDebian$1 */
    /* JADX INFO: compiled from: TorraStreamExtractor.kt */
    @Metadata(k = 3, mv = {2, 4, 0}, xi = 48)
    @DebugMetadata(c = "com.phisher98.TorraStreamExtractorKt", f = "TorraStreamExtractor.kt", i = {0, 0, 0, 0, 0, 0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1}, l = {83, 109}, m = "invokeTorrentioDebian", n = {"mainUrl", "id", "season", "episode", "filtered", "url", "mainUrl", "id", "season", "episode", "filtered", "url", "res", "$this$forEach$iv", "element$iv", "stream", "fileUrl", "seedersNum", "name", "cache", "formattedName", "size", "parts", "suffix", "finalTitle"}, nl = {824, 108}, s = {"L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$6", "L$7", "L$9", "L$10", "L$11", "L$12", "L$13", "L$14", "L$15", "L$16", "L$17", "L$18", "L$19"}, v = 2)
    static final class C00491 extends ContinuationImpl {
        Object L$0;
        Object L$1;
        Object L$10;
        Object L$11;
        Object L$12;
        Object L$13;
        Object L$14;
        Object L$15;
        Object L$16;
        Object L$17;
        Object L$18;
        Object L$19;
        Object L$2;
        Object L$20;
        Object L$3;
        Object L$4;
        Object L$5;
        Object L$6;
        Object L$7;
        Object L$8;
        Object L$9;
        int label;
        /* synthetic */ Object result;

        C00491(Continuation<? super C00491> continuation) {
            super(continuation);
        }

        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return TorraStreamExtractorKt.invokeTorrentioDebian(null, null, null, null, null, (Continuation) this);
        }
    }

    /* JADX INFO: renamed from: com.phisher98.TorraStreamExtractorKt$invokeTorrentsDB$1 */
    /* JADX INFO: compiled from: TorraStreamExtractor.kt */
    @Metadata(k = 3, mv = {2, 4, 0}, xi = 48)
    @DebugMetadata(c = "com.phisher98.TorraStreamExtractorKt", f = "TorraStreamExtractor.kt", i = {0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 1, 1, 1, 1, 1}, l = {625, 628}, m = "invokeTorrentsDB", n = {"mainUrl", "id", "season", "episode", "callback", "url", "headers", "mainUrl", "id", "season", "episode", "callback", "url", "headers", "response"}, nl = {626, 651}, s = {"L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$6", "L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$6", "L$7"}, v = 2)
    static final class C00501 extends ContinuationImpl {
        Object L$0;
        Object L$1;
        Object L$2;
        Object L$3;
        Object L$4;
        Object L$5;
        Object L$6;
        Object L$7;
        int label;
        /* synthetic */ Object result;

        C00501(Continuation<? super C00501> continuation) {
            super(continuation);
        }

        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return TorraStreamExtractorKt.invokeTorrentsDB(null, null, null, null, null, (Continuation) this);
        }
    }

    /* JADX INFO: renamed from: com.phisher98.TorraStreamExtractorKt$invokeTorrentsDBAnime$1 */
    /* JADX INFO: compiled from: TorraStreamExtractor.kt */
    @Metadata(k = 3, mv = {2, 4, 0}, xi = 48)
    @DebugMetadata(c = "com.phisher98.TorraStreamExtractorKt", f = "TorraStreamExtractor.kt", i = {0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 1, 1, 1, 1, 1}, l = {674, 677}, m = "invokeTorrentsDBAnime", n = {"mainUrl", "id", "season", "episode", "filtered", "url", "headers", "mainUrl", "id", "season", "episode", "filtered", "url", "headers", "response"}, nl = {675, 700}, s = {"L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$6", "L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$6", "L$7"}, v = 2)
    static final class C00531 extends ContinuationImpl {
        Object L$0;
        Object L$1;
        Object L$2;
        Object L$3;
        Object L$4;
        Object L$5;
        Object L$6;
        Object L$7;
        int label;
        /* synthetic */ Object result;

        C00531(Continuation<? super C00531> continuation) {
            super(continuation);
        }

        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return TorraStreamExtractorKt.invokeTorrentsDBAnime(null, null, null, null, null, (Continuation) this);
        }
    }

    /* JADX INFO: renamed from: com.phisher98.TorraStreamExtractorKt$invokeUindex$1 */
    /* JADX INFO: compiled from: TorraStreamExtractor.kt */
    @Metadata(k = 3, mv = {2, 4, 0}, xi = 48)
    @DebugMetadata(c = "com.phisher98.TorraStreamExtractorKt", f = "TorraStreamExtractor.kt", i = {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1}, l = {444, 461}, m = "invokeUindex", n = {"uindex", "title", "year", "season", "episode", "filtered", "searchQuery", "url", "headers", "isTv", "uindex", "title", "year", "season", "episode", "filtered", "searchQuery", "url", "headers", "rows", "episodePatterns", "isTv"}, nl = {446, 508}, s = {"L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$6", "L$7", "L$8", "I$0", "L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$6", "L$7", "L$8", "L$9", "L$10", "I$0"}, v = 2)
    static final class C00561 extends ContinuationImpl {
        int I$0;
        Object L$0;
        Object L$1;
        Object L$10;
        Object L$2;
        Object L$3;
        Object L$4;
        Object L$5;
        Object L$6;
        Object L$7;
        Object L$8;
        Object L$9;
        int label;
        /* synthetic */ Object result;

        C00561(Continuation<? super C00561> continuation) {
            super(continuation);
        }

        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return TorraStreamExtractorKt.invokeUindex(null, null, null, null, null, null, (Continuation) this);
        }
    }

    /* JADX WARN: Code duplicated, block: B:35:0x0287  */
    /* JADX WARN: Code duplicated, block: B:37:0x029a  */
    /* JADX WARN: Code duplicated, block: B:39:0x0304  */
    /* JADX WARN: Code duplicated, block: B:44:0x0314  */
    /* JADX WARN: Code duplicated, block: B:48:0x032d  */
    /* JADX WARN: Code duplicated, block: B:55:0x0349  */
    /* JADX WARN: Code duplicated, block: B:58:0x037e  */
    /* JADX WARN: Code duplicated, block: B:61:0x03a1  */
    /* JADX WARN: Code duplicated, block: B:64:0x03af  */
    /* JADX WARN: Code duplicated, block: B:67:0x03c1  */
    /* JADX WARN: Code duplicated, block: B:70:0x0421 A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:71:0x0422  */
    /* JADX WARN: Code duplicated, block: B:74:0x0444  */
    /* JADX WARN: Code duplicated, block: B:76:0x044a  */
    /* JADX WARN: Code duplicated, block: B:77:0x044d  */
    /* JADX WARN: Code duplicated, block: B:7:0x0018  */
    /* JADX WARN: Code duplicated, block: B:80:0x04d3 A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:81:0x04d4  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:81:0x04d4 -> B:82:0x04f0). Please report as a decompilation issue!!! */
    /*  JADX ERROR: JadxOverflowException in pass: RegionMakerVisitor
        jadx.core.utils.exceptions.JadxOverflowException: Regions stack size limit reached
        	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:59)
        	at jadx.core.utils.ErrorsCounter.error(ErrorsCounter.java:31)
        	at jadx.core.dex.attributes.nodes.NotificationAttrNode.addError(NotificationAttrNode.java:19)
        */
    @org.jetbrains.annotations.Nullable
    public static final java.lang.Object invokeTorrentio(@org.jetbrains.annotations.NotNull java.lang.String r35, @org.jetbrains.annotations.Nullable java.lang.String r36, @org.jetbrains.annotations.Nullable java.lang.Integer r37, @org.jetbrains.annotations.Nullable java.lang.Integer r38, @org.jetbrains.annotations.NotNull kotlin.jvm.functions.Function1<? super com.lagradost.cloudstream3.utils.ExtractorLink, kotlin.Unit> r39, @org.jetbrains.annotations.NotNull kotlin.coroutines.Continuation<? super kotlin.Unit> r40) {
        /*
            Method dump skipped, instruction units count: 1344
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.phisher98.TorraStreamExtractorKt.invokeTorrentio(java.lang.String, java.lang.String, java.lang.Integer, java.lang.Integer, kotlin.jvm.functions.Function1, kotlin.coroutines.Continuation):java.lang.Object");
    }

    public static /* synthetic */ Object invokeTorrentio$default(String str, String str2, Integer num, Integer num2, Function1 function1, Continuation continuation, int i, Object obj) {
        if ((i & 2) != 0) {
            str2 = null;
        }
        if ((i & 4) != 0) {
            num = null;
        }
        if ((i & 8) != 0) {
            num2 = null;
        }
        return invokeTorrentio(str, str2, num, num2, function1, continuation);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final String invokeTorrentio$lambda$0$0$0(MatchResult it) {
        String upperCase = it.getValue().toUpperCase(Locale.ROOT);
        Intrinsics.checkNotNullExpressionValue(upperCase, "toUpperCase(...)");
        return upperCase;
    }

    /* JADX WARN: Code duplicated, block: B:34:0x01f4  */
    /* JADX WARN: Code duplicated, block: B:36:0x0226  */
    /* JADX WARN: Code duplicated, block: B:37:0x0270  */
    /* JADX WARN: Code duplicated, block: B:40:0x028a  */
    /* JADX WARN: Code duplicated, block: B:43:0x0299  */
    /* JADX WARN: Code duplicated, block: B:46:0x02a4  */
    /* JADX WARN: Code duplicated, block: B:49:0x02cb  */
    /* JADX WARN: Code duplicated, block: B:52:0x02da  */
    /* JADX WARN: Code duplicated, block: B:55:0x0302  */
    /* JADX WARN: Code duplicated, block: B:56:0x031b  */
    /* JADX WARN: Code duplicated, block: B:58:0x031e  */
    /* JADX WARN: Code duplicated, block: B:59:0x0339  */
    /* JADX WARN: Code duplicated, block: B:62:0x034e  */
    /* JADX WARN: Code duplicated, block: B:63:0x037c  */
    /* JADX WARN: Code duplicated, block: B:66:0x0457 A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:67:0x0458  */
    /* JADX WARN: Code duplicated, block: B:7:0x001a  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:67:0x0458 -> B:68:0x0477). Please report as a decompilation issue!!! */
    /*  JADX ERROR: JadxOverflowException in pass: RegionMakerVisitor
        jadx.core.utils.exceptions.JadxOverflowException: Regions stack size limit reached
        	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:59)
        	at jadx.core.utils.ErrorsCounter.error(ErrorsCounter.java:31)
        	at jadx.core.dex.attributes.nodes.NotificationAttrNode.addError(NotificationAttrNode.java:19)
        */
    @org.jetbrains.annotations.Nullable
    public static final java.lang.Object invokeTorrentioDebian(@org.jetbrains.annotations.NotNull java.lang.String r38, @org.jetbrains.annotations.Nullable java.lang.String r39, @org.jetbrains.annotations.Nullable java.lang.Integer r40, @org.jetbrains.annotations.Nullable java.lang.Integer r41, @org.jetbrains.annotations.NotNull kotlin.jvm.functions.Function1<? super com.lagradost.cloudstream3.utils.ExtractorLink, kotlin.Unit> r42, @org.jetbrains.annotations.NotNull kotlin.coroutines.Continuation<? super kotlin.Unit> r43) {
        /*
            Method dump skipped, instruction units count: 1206
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.phisher98.TorraStreamExtractorKt.invokeTorrentioDebian(java.lang.String, java.lang.String, java.lang.Integer, java.lang.Integer, kotlin.jvm.functions.Function1, kotlin.coroutines.Continuation):java.lang.Object");
    }

    public static /* synthetic */ Object invokeTorrentioDebian$default(String str, String str2, Integer num, Integer num2, Function1 function1, Continuation continuation, int i, Object obj) {
        if ((i & 2) != 0) {
            str2 = null;
        }
        if ((i & 4) != 0) {
            num = null;
        }
        if ((i & 8) != 0) {
            num2 = null;
        }
        return invokeTorrentioDebian(str, str2, num, num2, function1, continuation);
    }

    /* JADX WARN: Code duplicated, block: B:34:0x01ec  */
    /* JADX WARN: Code duplicated, block: B:36:0x021e  */
    /* JADX WARN: Code duplicated, block: B:37:0x0268  */
    /* JADX WARN: Code duplicated, block: B:40:0x0282  */
    /* JADX WARN: Code duplicated, block: B:43:0x0291  */
    /* JADX WARN: Code duplicated, block: B:46:0x029c  */
    /* JADX WARN: Code duplicated, block: B:49:0x02c3  */
    /* JADX WARN: Code duplicated, block: B:52:0x02d2  */
    /* JADX WARN: Code duplicated, block: B:55:0x02fa  */
    /* JADX WARN: Code duplicated, block: B:56:0x0313  */
    /* JADX WARN: Code duplicated, block: B:58:0x0316  */
    /* JADX WARN: Code duplicated, block: B:59:0x0331  */
    /* JADX WARN: Code duplicated, block: B:62:0x0346  */
    /* JADX WARN: Code duplicated, block: B:63:0x0374  */
    /* JADX WARN: Code duplicated, block: B:66:0x044f A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:67:0x0450  */
    /* JADX WARN: Code duplicated, block: B:7:0x001a  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:67:0x0450 -> B:68:0x046f). Please report as a decompilation issue!!! */
    /*  JADX ERROR: JadxOverflowException in pass: RegionMakerVisitor
        jadx.core.utils.exceptions.JadxOverflowException: Regions stack size limit reached
        	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:59)
        	at jadx.core.utils.ErrorsCounter.error(ErrorsCounter.java:31)
        	at jadx.core.dex.attributes.nodes.NotificationAttrNode.addError(NotificationAttrNode.java:19)
        */
    @org.jetbrains.annotations.Nullable
    public static final java.lang.Object invokeTorrentioAnimeDebian(@org.jetbrains.annotations.NotNull java.lang.String r38, @org.jetbrains.annotations.NotNull com.lagradost.cloudstream3.TvType r39, @org.jetbrains.annotations.Nullable java.lang.Integer r40, @org.jetbrains.annotations.Nullable java.lang.Integer r41, @org.jetbrains.annotations.NotNull kotlin.jvm.functions.Function1<? super com.lagradost.cloudstream3.utils.ExtractorLink, kotlin.Unit> r42, @org.jetbrains.annotations.NotNull kotlin.coroutines.Continuation<? super kotlin.Unit> r43) {
        /*
            Method dump skipped, instruction units count: 1198
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.phisher98.TorraStreamExtractorKt.invokeTorrentioAnimeDebian(java.lang.String, com.lagradost.cloudstream3.TvType, java.lang.Integer, java.lang.Integer, kotlin.jvm.functions.Function1, kotlin.coroutines.Continuation):java.lang.Object");
    }

    public static /* synthetic */ Object invokeTorrentioAnimeDebian$default(String str, TvType tvType, Integer num, Integer num2, Function1 function1, Continuation continuation, int i, Object obj) {
        if ((i & 4) != 0) {
            num = null;
        }
        if ((i & 8) != 0) {
            num2 = null;
        }
        return invokeTorrentioAnimeDebian(str, tvType, num, num2, function1, continuation);
    }

    /* JADX WARN: Code duplicated, block: B:35:0x026d  */
    /* JADX WARN: Code duplicated, block: B:37:0x0280  */
    /* JADX WARN: Code duplicated, block: B:39:0x02e8  */
    /* JADX WARN: Code duplicated, block: B:44:0x02f8  */
    /* JADX WARN: Code duplicated, block: B:48:0x0311  */
    /* JADX WARN: Code duplicated, block: B:55:0x032d  */
    /* JADX WARN: Code duplicated, block: B:58:0x0362  */
    /* JADX WARN: Code duplicated, block: B:61:0x0383  */
    /* JADX WARN: Code duplicated, block: B:64:0x0391  */
    /* JADX WARN: Code duplicated, block: B:67:0x03a3  */
    /* JADX WARN: Code duplicated, block: B:70:0x03fd A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:71:0x03fe  */
    /* JADX WARN: Code duplicated, block: B:74:0x0418  */
    /* JADX WARN: Code duplicated, block: B:76:0x041e  */
    /* JADX WARN: Code duplicated, block: B:77:0x0421  */
    /* JADX WARN: Code duplicated, block: B:7:0x001a  */
    /* JADX WARN: Code duplicated, block: B:80:0x049f A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:81:0x04a0  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:81:0x04a0 -> B:82:0x04b7). Please report as a decompilation issue!!! */
    /*  JADX ERROR: JadxOverflowException in pass: RegionMakerVisitor
        jadx.core.utils.exceptions.JadxOverflowException: Regions stack size limit reached
        	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:59)
        	at jadx.core.utils.ErrorsCounter.error(ErrorsCounter.java:31)
        	at jadx.core.dex.attributes.nodes.NotificationAttrNode.addError(NotificationAttrNode.java:19)
        */
    @org.jetbrains.annotations.Nullable
    public static final java.lang.Object invokeTorrentioAnimeType(@org.jetbrains.annotations.NotNull java.lang.String r35, @org.jetbrains.annotations.NotNull com.lagradost.cloudstream3.TvType r36, @org.jetbrains.annotations.Nullable java.lang.Integer r37, @org.jetbrains.annotations.Nullable java.lang.Integer r38, @org.jetbrains.annotations.NotNull kotlin.jvm.functions.Function1<? super com.lagradost.cloudstream3.utils.ExtractorLink, kotlin.Unit> r39, @org.jetbrains.annotations.NotNull kotlin.coroutines.Continuation<? super kotlin.Unit> r40) {
        /*
            Method dump skipped, instruction units count: 1278
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.phisher98.TorraStreamExtractorKt.invokeTorrentioAnimeType(java.lang.String, com.lagradost.cloudstream3.TvType, java.lang.Integer, java.lang.Integer, kotlin.jvm.functions.Function1, kotlin.coroutines.Continuation):java.lang.Object");
    }

    public static /* synthetic */ Object invokeTorrentioAnimeType$default(String str, TvType tvType, Integer num, Integer num2, Function1 function1, Continuation continuation, int i, Object obj) {
        if ((i & 4) != 0) {
            num = null;
        }
        if ((i & 8) != 0) {
            num2 = null;
        }
        return invokeTorrentioAnimeType(str, tvType, num, num2, function1, continuation);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final String invokeTorrentioAnimeType$lambda$0$0$0(MatchResult it) {
        String upperCase = it.getValue().toUpperCase(Locale.ROOT);
        Intrinsics.checkNotNullExpressionValue(upperCase, "toUpperCase(...)");
        return upperCase;
    }

    /* JADX WARN: Code duplicated, block: B:54:0x01f6 A[Catch: Exception -> 0x0305, TRY_LEAVE, TryCatch #10 {Exception -> 0x0305, blocks: (B:52:0x01f0, B:54:0x01f6), top: B:107:0x01f0 }] */
    /* JADX WARN: Code duplicated, block: B:56:0x023d A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:57:0x023e  */
    /* JADX WARN: Code duplicated, block: B:64:0x02d9 A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:65:0x02da  */
    /* JADX WARN: Code duplicated, block: B:7:0x001a  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:65:0x02da -> B:97:0x02e8). Please report as a decompilation issue!!! */
    /*  JADX ERROR: JadxOverflowException in pass: RegionMakerVisitor
        jadx.core.utils.exceptions.JadxOverflowException: Regions stack size limit reached
        	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:59)
        	at jadx.core.utils.ErrorsCounter.error(ErrorsCounter.java:31)
        	at jadx.core.dex.attributes.nodes.NotificationAttrNode.addError(NotificationAttrNode.java:19)
        */
    @org.jetbrains.annotations.Nullable
    public static final java.lang.Object invokeThepiratebay(@org.jetbrains.annotations.Nullable java.lang.String r24, @org.jetbrains.annotations.Nullable java.lang.String r25, @org.jetbrains.annotations.Nullable java.lang.Integer r26, @org.jetbrains.annotations.Nullable java.lang.Integer r27, @org.jetbrains.annotations.NotNull kotlin.jvm.functions.Function1<? super com.lagradost.cloudstream3.utils.ExtractorLink, kotlin.Unit> r28, @org.jetbrains.annotations.NotNull kotlin.coroutines.Continuation<? super kotlin.Unit> r29) {
        /*
            Method dump skipped, instruction units count: 842
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.phisher98.TorraStreamExtractorKt.invokeThepiratebay(java.lang.String, java.lang.String, java.lang.Integer, java.lang.Integer, kotlin.jvm.functions.Function1, kotlin.coroutines.Continuation):java.lang.Object");
    }

    public static /* synthetic */ Object invokeThepiratebay$default(String str, String str2, Integer num, Integer num2, Function1 function1, Continuation continuation, int i, Object obj) {
        if ((i & 1) != 0) {
            str = null;
        }
        if ((i & 2) != 0) {
            str2 = null;
        }
        if ((i & 4) != 0) {
            num = null;
        }
        if ((i & 8) != 0) {
            num2 = null;
        }
        return invokeThepiratebay(str, str2, num, num2, function1, continuation);
    }

    /* JADX INFO: renamed from: com.phisher98.TorraStreamExtractorKt$invokeThepiratebay$2 */
    /* JADX INFO: compiled from: TorraStreamExtractor.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lcom/lagradost/cloudstream3/utils/ExtractorLink;"}, k = 3, mv = {2, 4, 0}, xi = 48)
    @DebugMetadata(c = "com.phisher98.TorraStreamExtractorKt$invokeThepiratebay$2", f = "TorraStreamExtractor.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, nl = {}, s = {}, v = 2)
    static final class C00442 extends SuspendLambda implements Function2<ExtractorLink, Continuation<? super Unit>, Object> {
        final /* synthetic */ TBPStream $stream;
        private /* synthetic */ Object L$0;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C00442(TBPStream tBPStream, Continuation<? super C00442> continuation) {
            super(2, continuation);
            this.$stream = tBPStream;
        }

        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            Continuation<Unit> c00442 = new C00442(this.$stream, continuation);
            c00442.L$0 = obj;
            return c00442;
        }

        public final Object invoke(ExtractorLink extractorLink, Continuation<? super Unit> continuation) {
            return create(extractorLink, continuation).invokeSuspend(Unit.INSTANCE);
        }

        public final Object invokeSuspend(Object $result) {
            ExtractorLink $this$newExtractorLink = (ExtractorLink) this.L$0;
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            switch (this.label) {
                case 0:
                    ResultKt.throwOnFailure($result);
                    $this$newExtractorLink.setReferer("");
                    $this$newExtractorLink.setQuality(TorraStreamUtilsKt.getIndexQuality(this.$stream.getTitle()));
                    return Unit.INSTANCE;
                default:
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
        }
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0018  */
    @Nullable
    public static final Object invokeSubtitleAPI(@Nullable String id, @Nullable Integer season, @Nullable Integer episode, @NotNull Function1<? super SubtitleFile, Unit> function1, @NotNull Continuation<? super Unit> continuation) {
        C00411 c00411;
        Integer num;
        String url;
        Object obj;
        C00411 c00412;
        Object $result;
        Object obj2;
        String url2;
        Map headers;
        Integer season2;
        Integer episode2;
        Function1<? super SubtitleFile, Unit> function2;
        Object safe;
        SubtitlesAPI subtitlesAPI;
        List<Subtitle1> subtitles;
        if (continuation instanceof C00411) {
            c00411 = (C00411) continuation;
            if ((c00411.label & Integer.MIN_VALUE) != 0) {
                c00411.label -= Integer.MIN_VALUE;
            } else {
                c00411 = new C00411(continuation);
            }
        } else {
            c00411 = new C00411(continuation);
        }
        Object $result2 = c00411.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (c00411.label) {
            case 0:
                ResultKt.throwOnFailure($result2);
                if (season == null) {
                    url = "https://opensubtitles-v3.strem.io/subtitles/movie/" + id + ".json";
                    num = episode;
                } else {
                    num = episode;
                    url = "https://opensubtitles-v3.strem.io/subtitles/series/" + id + ':' + season.intValue() + ':' + num + ".json";
                }
                Map headers2 = MapsKt.mapOf(TuplesKt.to("User-Agent", "Mozilla/5.0 (X11; Linux x86_64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/126.0.0.0 Safari/537.36"));
                Requests app = MainActivityKt.getApp();
                c00411.L$0 = SpillingKt.nullOutSpilledVariable(id);
                c00411.L$1 = SpillingKt.nullOutSpilledVariable(season);
                c00411.L$2 = SpillingKt.nullOutSpilledVariable(num);
                c00411.L$3 = function1;
                c00411.L$4 = SpillingKt.nullOutSpilledVariable(url);
                c00411.L$5 = SpillingKt.nullOutSpilledVariable(headers2);
                c00411.label = 1;
                String url3 = url;
                C00411 c00413 = c00411;
                obj = coroutine_suspended;
                Object obj3 = Requests.get$default(app, url3, headers2, (String) null, (Map) null, (Map) null, false, 0, (TimeUnit) null, 100L, (Interceptor) null, false, (ResponseParser) null, c00413, 3836, (Object) null);
                c00412 = c00413;
                if (obj3 == obj) {
                    return obj;
                }
                $result = id;
                obj2 = obj3;
                url2 = url3;
                headers = headers2;
                season2 = season;
                episode2 = episode;
                function2 = function1;
                NiceResponse this_$iv = (NiceResponse) obj2;
                try {
                    ResponseParser parser = this_$iv.getParser();
                    Intrinsics.checkNotNull(parser);
                    safe = parser.parseSafe(this_$iv.getText(), Reflection.getOrCreateKotlinClass(SubtitlesAPI.class));
                    break;
                } catch (Exception e$iv) {
                    e$iv.printStackTrace();
                    safe = null;
                }
                subtitlesAPI = (SubtitlesAPI) safe;
                if (subtitlesAPI != null || (subtitles = subtitlesAPI.getSubtitles()) == null) {
                    return Unit.INSTANCE;
                }
                C00422 c00422 = new C00422(function2, null);
                c00412.L$0 = SpillingKt.nullOutSpilledVariable($result);
                c00412.L$1 = SpillingKt.nullOutSpilledVariable(season2);
                c00412.L$2 = SpillingKt.nullOutSpilledVariable(episode2);
                c00412.L$3 = SpillingKt.nullOutSpilledVariable(function2);
                c00412.L$4 = SpillingKt.nullOutSpilledVariable(url2);
                c00412.L$5 = SpillingKt.nullOutSpilledVariable(headers);
                c00412.label = 2;
                return ParCollectionsKt.amap(subtitles, c00422, c00412) == obj ? obj : Unit.INSTANCE;
            case 1:
                headers = (Map) c00411.L$5;
                url2 = (String) c00411.L$4;
                function2 = (Function1) c00411.L$3;
                episode2 = (Integer) c00411.L$2;
                season2 = (Integer) c00411.L$1;
                Object id2 = (String) c00411.L$0;
                ResultKt.throwOnFailure($result2);
                c00412 = c00411;
                obj = coroutine_suspended;
                $result = id2;
                obj2 = $result2;
                NiceResponse this_$iv2 = (NiceResponse) obj2;
                ResponseParser parser2 = this_$iv2.getParser();
                Intrinsics.checkNotNull(parser2);
                safe = parser2.parseSafe(this_$iv2.getText(), Reflection.getOrCreateKotlinClass(SubtitlesAPI.class));
                subtitlesAPI = (SubtitlesAPI) safe;
                if (subtitlesAPI != null) {
                    break;
                }
                return Unit.INSTANCE;
            case 2:
                ResultKt.throwOnFailure($result2);
            default:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    public static /* synthetic */ Object invokeSubtitleAPI$default(String str, Integer num, Integer num2, Function1 function1, Continuation continuation, int i, Object obj) {
        if ((i & 1) != 0) {
            str = null;
        }
        if ((i & 2) != 0) {
            num = null;
        }
        if ((i & 4) != 0) {
            num2 = null;
        }
        return invokeSubtitleAPI(str, num, num2, function1, continuation);
    }

    /* JADX INFO: renamed from: com.phisher98.TorraStreamExtractorKt$invokeSubtitleAPI$2 */
    /* JADX INFO: compiled from: TorraStreamExtractor.kt */
    @Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n"}, d2 = {"<anonymous>", "", "it", "Lcom/phisher98/Subtitle1;"}, k = 3, mv = {2, 4, 0}, xi = 48)
    @DebugMetadata(c = "com.phisher98.TorraStreamExtractorKt$invokeSubtitleAPI$2", f = "TorraStreamExtractor.kt", i = {0, 0, 0}, l = {279}, m = "invokeSuspend", n = {"it", "lan", "suburl"}, nl = {278}, s = {"L$0", "L$1", "L$2"}, v = 2)
    @SourceDebugExtension({"SMAP\nTorraStreamExtractor.kt\nKotlin\n*S Kotlin\n*F\n+ 1 TorraStreamExtractor.kt\ncom/phisher98/TorraStreamExtractorKt$invokeSubtitleAPI$2\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,823:1\n1#2:824\n*E\n"})
    static final class C00422 extends SuspendLambda implements Function2<Subtitle1, Continuation<? super Unit>, Object> {
        final /* synthetic */ Function1<SubtitleFile, Unit> $subtitleCallback;
        /* synthetic */ Object L$0;
        Object L$1;
        Object L$2;
        Object L$3;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C00422(Function1<? super SubtitleFile, Unit> function1, Continuation<? super C00422> continuation) {
            super(2, continuation);
            this.$subtitleCallback = function1;
        }

        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            Continuation<Unit> c00422 = new C00422(this.$subtitleCallback, continuation);
            c00422.L$0 = obj;
            return c00422;
        }

        public final Object invoke(Subtitle1 subtitle1, Continuation<? super Unit> continuation) {
            return create(subtitle1, continuation).invokeSuspend(Unit.INSTANCE);
        }

        public final Object invokeSuspend(Object $result) {
            String string;
            Object objNewSubtitleFile$default;
            Function1<SubtitleFile, Unit> function1;
            Subtitle1 it = (Subtitle1) this.L$0;
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            switch (this.label) {
                case 0:
                    ResultKt.throwOnFailure($result);
                    String language = TorraStreamUtilsKt.getLanguage(it.getLang());
                    if (language == null) {
                        language = "Unknown";
                    }
                    String lan = language;
                    String suburl = it.getUrl();
                    Function1<SubtitleFile, Unit> function2 = this.$subtitleCallback;
                    if (lan.length() > 0) {
                        StringBuilder sb = new StringBuilder();
                        char it2 = lan.charAt(0);
                        StringBuilder sbAppend = sb.append((Object) (Character.isLowerCase((char) it2) ? CharsKt.titlecase(it2, Locale.getDefault()) : String.valueOf(it2)));
                        String strSubstring = lan.substring(1);
                        Intrinsics.checkNotNullExpressionValue(strSubstring, "substring(...)");
                        string = sbAppend.append(strSubstring).toString();
                    } else {
                        string = lan;
                    }
                    this.L$0 = SpillingKt.nullOutSpilledVariable(it);
                    this.L$1 = SpillingKt.nullOutSpilledVariable(lan);
                    this.L$2 = SpillingKt.nullOutSpilledVariable(suburl);
                    this.L$3 = function2;
                    this.label = 1;
                    objNewSubtitleFile$default = MainAPIKt.newSubtitleFile$default(string, suburl, (Function2) null, (Continuation) this, 4, (Object) null);
                    if (objNewSubtitleFile$default == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    function1 = function2;
                    break;
                    break;
                case 1:
                    function1 = (Function1) this.L$3;
                    ResultKt.throwOnFailure($result);
                    objNewSubtitleFile$default = $result;
                    break;
                default:
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            function1.invoke(objNewSubtitleFile$default);
            return Unit.INSTANCE;
        }
    }

    /* JADX WARN: Code duplicated, block: B:34:0x0150  */
    /* JADX WARN: Code duplicated, block: B:36:0x01a2  */
    /* JADX WARN: Code duplicated, block: B:39:0x0237 A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:40:0x0238  */
    /* JADX WARN: Code duplicated, block: B:7:0x0016  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:40:0x0238 -> B:41:0x0245). Please report as a decompilation issue!!! */
    /*  JADX ERROR: JadxOverflowException in pass: RegionMakerVisitor
        jadx.core.utils.exceptions.JadxOverflowException: Regions stack size limit reached
        	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:59)
        	at jadx.core.utils.ErrorsCounter.error(ErrorsCounter.java:31)
        	at jadx.core.dex.attributes.nodes.NotificationAttrNode.addError(NotificationAttrNode.java:19)
        */
    @org.jetbrains.annotations.Nullable
    public static final java.lang.Object invokeAnimetosho(@org.jetbrains.annotations.Nullable java.lang.Integer r30, @org.jetbrains.annotations.NotNull kotlin.jvm.functions.Function1<? super com.lagradost.cloudstream3.utils.ExtractorLink, kotlin.Unit> r31, @org.jetbrains.annotations.NotNull kotlin.coroutines.Continuation<? super kotlin.Unit> r32) {
        /*
            Method dump skipped, instruction units count: 606
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.phisher98.TorraStreamExtractorKt.invokeAnimetosho(java.lang.Integer, kotlin.jvm.functions.Function1, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final CharSequence invokeAnimetosho$lambda$1$0(MatchResult it) {
        return '[' + ((String) it.getGroupValues().get(1)) + ']';
    }

    /* JADX WARN: Code duplicated, block: B:35:0x0264  */
    /* JADX WARN: Code duplicated, block: B:37:0x02d0 A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:38:0x02d1  */
    /* JADX WARN: Code duplicated, block: B:41:0x02ef  */
    /* JADX WARN: Code duplicated, block: B:43:0x0345  */
    /* JADX WARN: Code duplicated, block: B:47:0x0354  */
    /* JADX WARN: Code duplicated, block: B:50:0x036c  */
    /* JADX WARN: Code duplicated, block: B:57:0x0388  */
    /* JADX WARN: Code duplicated, block: B:60:0x03bd  */
    /* JADX WARN: Code duplicated, block: B:63:0x03d4  */
    /* JADX WARN: Code duplicated, block: B:64:0x03d7  */
    /* JADX WARN: Code duplicated, block: B:67:0x0452 A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:68:0x0453  */
    /* JADX WARN: Code duplicated, block: B:7:0x0018  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:68:0x0453 -> B:69:0x0474). Please report as a decompilation issue!!! */
    /*  JADX ERROR: JadxOverflowException in pass: RegionMakerVisitor
        jadx.core.utils.exceptions.JadxOverflowException: Regions stack size limit reached
        	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:59)
        	at jadx.core.utils.ErrorsCounter.error(ErrorsCounter.java:31)
        	at jadx.core.dex.attributes.nodes.NotificationAttrNode.addError(NotificationAttrNode.java:19)
        */
    @org.jetbrains.annotations.Nullable
    public static final java.lang.Object invokeTorrentioAnime(@org.jetbrains.annotations.NotNull java.lang.String r39, @org.jetbrains.annotations.Nullable java.lang.Integer r40, @org.jetbrains.annotations.Nullable java.lang.Integer r41, @org.jetbrains.annotations.Nullable java.lang.Integer r42, @org.jetbrains.annotations.NotNull kotlin.jvm.functions.Function1<? super com.lagradost.cloudstream3.utils.ExtractorLink, kotlin.Unit> r43, @org.jetbrains.annotations.NotNull kotlin.coroutines.Continuation<? super kotlin.Unit> r44) {
        /*
            Method dump skipped, instruction units count: 1200
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.phisher98.TorraStreamExtractorKt.invokeTorrentioAnime(java.lang.String, java.lang.Integer, java.lang.Integer, java.lang.Integer, kotlin.jvm.functions.Function1, kotlin.coroutines.Continuation):java.lang.Object");
    }

    public static /* synthetic */ Object invokeTorrentioAnime$default(String str, Integer num, Integer num2, Integer num3, Function1 function1, Continuation continuation, int i, Object obj) {
        if ((i & 2) != 0) {
            num = null;
        }
        if ((i & 4) != 0) {
            num2 = null;
        }
        if ((i & 8) != 0) {
            num3 = null;
        }
        return invokeTorrentioAnime(str, num, num2, num3, function1, continuation);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final String invokeTorrentioAnime$lambda$0$0$0(MatchResult match) {
        return '[' + ((String) match.getGroupValues().get(1)) + ']';
    }

    /* JADX WARN: Code duplicated, block: B:44:0x020e  */
    /* JADX WARN: Code duplicated, block: B:46:0x021e  */
    /* JADX WARN: Code duplicated, block: B:47:0x0222  */
    /* JADX WARN: Code duplicated, block: B:49:0x0262  */
    /* JADX WARN: Code duplicated, block: B:51:0x0268  */
    /* JADX WARN: Code duplicated, block: B:54:0x0274  */
    /* JADX WARN: Code duplicated, block: B:56:0x027a  */
    /* JADX WARN: Code duplicated, block: B:57:0x027f  */
    /* JADX WARN: Code duplicated, block: B:59:0x0283  */
    /* JADX WARN: Code duplicated, block: B:62:0x0308 A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:63:0x0309  */
    /* JADX WARN: Code duplicated, block: B:7:0x0018  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:46:0x021e -> B:65:0x032e). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:63:0x0309 -> B:64:0x0320). Please report as a decompilation issue!!! */
    /*  JADX ERROR: JadxOverflowException in pass: RegionMakerVisitor
        jadx.core.utils.exceptions.JadxOverflowException: Regions stack size limit reached
        	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:59)
        	at jadx.core.utils.ErrorsCounter.error(ErrorsCounter.java:31)
        	at jadx.core.dex.attributes.nodes.NotificationAttrNode.addError(NotificationAttrNode.java:19)
        */
    @org.jetbrains.annotations.Nullable
    public static final java.lang.Object invokeAIOStreamsDebian(@org.jetbrains.annotations.NotNull java.lang.String r35, @org.jetbrains.annotations.Nullable java.lang.String r36, @org.jetbrains.annotations.Nullable java.lang.Integer r37, @org.jetbrains.annotations.Nullable java.lang.Integer r38, @org.jetbrains.annotations.NotNull kotlin.jvm.functions.Function1<? super com.lagradost.cloudstream3.utils.ExtractorLink, kotlin.Unit> r39, @org.jetbrains.annotations.NotNull kotlin.coroutines.Continuation<? super kotlin.Unit> r40) {
        /*
            Method dump skipped, instruction units count: 834
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.phisher98.TorraStreamExtractorKt.invokeAIOStreamsDebian(java.lang.String, java.lang.String, java.lang.Integer, java.lang.Integer, kotlin.jvm.functions.Function1, kotlin.coroutines.Continuation):java.lang.Object");
    }

    public static /* synthetic */ Object invokeAIOStreamsDebian$default(String str, String str2, Integer num, Integer num2, Function1 function1, Continuation continuation, int i, Object obj) {
        if ((i & 2) != 0) {
            str2 = null;
        }
        if ((i & 4) != 0) {
            num = null;
        }
        if ((i & 8) != 0) {
            num2 = null;
        }
        return invokeAIOStreamsDebian(str, str2, num, num2, function1, continuation);
    }

    /* JADX WARN: Code duplicated, block: B:51:0x02c0  */
    /* JADX WARN: Code duplicated, block: B:54:0x02d5  */
    /* JADX WARN: Code duplicated, block: B:55:0x02d7  */
    /* JADX WARN: Code duplicated, block: B:58:0x032b A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:59:0x032c  */
    /* JADX WARN: Code duplicated, block: B:7:0x001a  */
    @Nullable
    public static final Object invokeUindex(@NotNull String uindex, @Nullable String title, @Nullable Integer year, @Nullable Integer season, @Nullable Integer episode, @NotNull Function1<? super ExtractorLink, Unit> function1, @NotNull Continuation<? super Unit> continuation) {
        C00561 c00561;
        char c;
        int i;
        Object obj;
        C00561 c00562;
        String uindex2;
        Integer year2;
        Integer episode2;
        Function1<? super ExtractorLink, Unit> function2;
        String url;
        Map headers;
        String url2;
        int i2;
        Object obj2;
        Integer season2;
        String title2;
        Integer season3;
        List listEmptyList;
        List list;
        boolean z;
        C00572 c00572;
        if (continuation instanceof C00561) {
            c00561 = (C00561) continuation;
            if ((c00561.label & Integer.MIN_VALUE) != 0) {
                c00561.label -= Integer.MIN_VALUE;
            } else {
                c00561 = new C00561(continuation);
            }
        } else {
            c00561 = new C00561(continuation);
        }
        Object $result = c00561.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (c00561.label) {
            case 0:
                ResultKt.throwOnFailure($result);
                int i3 = season != null ? 1 : 0;
                StringBuilder $this$invokeUindex_u24lambda_u240 = new StringBuilder();
                String str = title;
                if (!(str == null || StringsKt.isBlank(str))) {
                    $this$invokeUindex_u24lambda_u240.append(title);
                }
                if (year != null) {
                    if ($this$invokeUindex_u24lambda_u240.length() > 0) {
                        $this$invokeUindex_u24lambda_u240.append(' ');
                    }
                    $this$invokeUindex_u24lambda_u240.append(year.intValue());
                }
                String searchQuery = StringsKt.replace$default($this$invokeUindex_u24lambda_u240.toString(), ' ', '+', false, 4, (Object) null);
                String url3 = uindex + "/search.php?search=" + searchQuery + "&c=" + (i3 != 0 ? 2 : 1);
                Map headers2 = MapsKt.mapOf(new Pair[]{TuplesKt.to("Accept", "text/html,application/xhtml+xml,application/xml;q=0.9,image/avif,image/webp,image/apng,*/*;q=0.8"), TuplesKt.to("User-Agent", "Mozilla/5.0 (X11; Linux x86_64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/126.0.0.0 Safari/537.36")});
                Requests app = MainActivityKt.getApp();
                c00561.L$0 = SpillingKt.nullOutSpilledVariable(uindex);
                c00561.L$1 = SpillingKt.nullOutSpilledVariable(title);
                c00561.L$2 = SpillingKt.nullOutSpilledVariable(year);
                c00561.L$3 = season;
                c00561.L$4 = episode;
                c00561.L$5 = function1;
                c00561.L$6 = SpillingKt.nullOutSpilledVariable(searchQuery);
                c00561.L$7 = SpillingKt.nullOutSpilledVariable(url3);
                c00561.L$8 = SpillingKt.nullOutSpilledVariable(headers2);
                c00561.I$0 = i3;
                c00561.label = 1;
                int i4 = i3;
                c = 1;
                i = 2;
                C00561 c00563 = c00561;
                obj = coroutine_suspended;
                Object obj3 = Requests.get$default(app, url3, headers2, (String) null, (Map) null, (Map) null, false, 0, (TimeUnit) null, 0L, (Interceptor) null, false, (ResponseParser) null, c00563, 4092, (Object) null);
                c00562 = c00563;
                if (obj3 == obj) {
                    return obj;
                }
                uindex2 = uindex;
                year2 = year;
                episode2 = episode;
                function2 = function1;
                url = url3;
                headers = headers2;
                url2 = searchQuery;
                i2 = i4;
                obj2 = obj3;
                season2 = season;
                title2 = title;
                List episodePatterns = ((NiceResponse) obj2).getDocument().select("tr");
                if (i2 != 0 || episode2 == null) {
                    season3 = season2;
                    listEmptyList = CollectionsKt.emptyList();
                } else {
                    StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
                    Locale locale = Locale.US;
                    Object[] objArr = new Object[i];
                    objArr[0] = season2;
                    objArr[c] = episode2;
                    String str2 = String.format(locale, "S%02dE%02d", Arrays.copyOf(objArr, i));
                    Intrinsics.checkNotNullExpressionValue(str2, "format(...)");
                    String string = new StringBuilder().append('S').append(season2.intValue()).append('E').append(episode2.intValue()).toString();
                    StringCompanionObject stringCompanionObject2 = StringCompanionObject.INSTANCE;
                    Locale locale2 = Locale.US;
                    season3 = season2;
                    Object[] objArr2 = new Object[2];
                    objArr2[0] = season3;
                    objArr2[c] = episode2;
                    String str3 = String.format(locale2, "S%02dE%d", Arrays.copyOf(objArr2, 2));
                    Intrinsics.checkNotNullExpressionValue(str3, "format(...)");
                    StringCompanionObject stringCompanionObject3 = StringCompanionObject.INSTANCE;
                    Locale locale3 = Locale.US;
                    Object[] objArr3 = new Object[2];
                    objArr3[0] = season3;
                    objArr3[c] = episode2;
                    String str4 = String.format(locale3, "S%dE%02d", Arrays.copyOf(objArr3, 2));
                    Intrinsics.checkNotNullExpressionValue(str4, "format(...)");
                    List rawPatterns = CollectionsKt.listOf(new String[]{str2, string, str3, str4});
                    Iterable $this$map$iv = CollectionsKt.distinct(rawPatterns);
                    int $i$f$map = 0;
                    Collection destination$iv$iv = new ArrayList(CollectionsKt.collectionSizeOrDefault($this$map$iv, 10));
                    Iterable $this$mapTo$iv$iv = $this$map$iv;
                    for (Object item$iv$iv : $this$mapTo$iv$iv) {
                        List rawPatterns2 = rawPatterns;
                        String it = (String) item$iv$iv;
                        destination$iv$iv.add(new Regex("\\b" + it + "\\b", RegexOption.IGNORE_CASE));
                        rawPatterns = rawPatterns2;
                        $this$map$iv = $this$map$iv;
                        $i$f$map = $i$f$map;
                        $this$mapTo$iv$iv = $this$mapTo$iv$iv;
                    }
                    listEmptyList = (List) destination$iv$iv;
                }
                List episodePatterns2 = listEmptyList;
                list = episodePatterns;
                if (i2 != 0) {
                    z = true;
                } else {
                    z = false;
                }
                c00572 = new C00572(z, episodePatterns2, function2, null);
                c00562.L$0 = SpillingKt.nullOutSpilledVariable(uindex2);
                c00562.L$1 = SpillingKt.nullOutSpilledVariable(title2);
                c00562.L$2 = SpillingKt.nullOutSpilledVariable(year2);
                c00562.L$3 = SpillingKt.nullOutSpilledVariable(season3);
                c00562.L$4 = SpillingKt.nullOutSpilledVariable(episode2);
                c00562.L$5 = SpillingKt.nullOutSpilledVariable(function2);
                c00562.L$6 = SpillingKt.nullOutSpilledVariable(url2);
                c00562.L$7 = SpillingKt.nullOutSpilledVariable(url);
                c00562.L$8 = SpillingKt.nullOutSpilledVariable(headers);
                c00562.L$9 = SpillingKt.nullOutSpilledVariable(episodePatterns);
                c00562.L$10 = SpillingKt.nullOutSpilledVariable(episodePatterns2);
                c00562.I$0 = i2;
                c00562.label = 2;
                if (ParCollectionsKt.amap(list, c00572, c00562) == obj) {
                    return obj;
                }
                return Unit.INSTANCE;
            case 1:
                int i5 = c00561.I$0;
                Map headers3 = (Map) c00561.L$8;
                String url4 = (String) c00561.L$7;
                String searchQuery2 = (String) c00561.L$6;
                function2 = (Function1) c00561.L$5;
                episode2 = (Integer) c00561.L$4;
                Integer season4 = (Integer) c00561.L$3;
                year2 = (Integer) c00561.L$2;
                String title3 = (String) c00561.L$1;
                uindex2 = (String) c00561.L$0;
                ResultKt.throwOnFailure($result);
                c00562 = c00561;
                obj = coroutine_suspended;
                i2 = i5;
                headers = headers3;
                url = url4;
                url2 = searchQuery2;
                c = 1;
                season2 = season4;
                obj2 = $result;
                title2 = title3;
                i = 2;
                List episodePatterns3 = ((NiceResponse) obj2).getDocument().select("tr");
                if (i2 != 0) {
                    season3 = season2;
                    listEmptyList = CollectionsKt.emptyList();
                } else {
                    season3 = season2;
                    listEmptyList = CollectionsKt.emptyList();
                }
                List episodePatterns4 = listEmptyList;
                list = episodePatterns3;
                if (i2 != 0) {
                    z = true;
                } else {
                    z = false;
                }
                c00572 = new C00572(z, episodePatterns4, function2, null);
                c00562.L$0 = SpillingKt.nullOutSpilledVariable(uindex2);
                c00562.L$1 = SpillingKt.nullOutSpilledVariable(title2);
                c00562.L$2 = SpillingKt.nullOutSpilledVariable(year2);
                c00562.L$3 = SpillingKt.nullOutSpilledVariable(season3);
                c00562.L$4 = SpillingKt.nullOutSpilledVariable(episode2);
                c00562.L$5 = SpillingKt.nullOutSpilledVariable(function2);
                c00562.L$6 = SpillingKt.nullOutSpilledVariable(url2);
                c00562.L$7 = SpillingKt.nullOutSpilledVariable(url);
                c00562.L$8 = SpillingKt.nullOutSpilledVariable(headers);
                c00562.L$9 = SpillingKt.nullOutSpilledVariable(episodePatterns3);
                c00562.L$10 = SpillingKt.nullOutSpilledVariable(episodePatterns4);
                c00562.I$0 = i2;
                c00562.label = 2;
                if (ParCollectionsKt.amap(list, c00572, c00562) == obj) {
                    return obj;
                }
                return Unit.INSTANCE;
            case 2:
                int i6 = c00561.I$0;
                ResultKt.throwOnFailure($result);
                return Unit.INSTANCE;
            default:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    public static /* synthetic */ Object invokeUindex$default(String str, String str2, Integer num, Integer num2, Integer num3, Function1 function1, Continuation continuation, int i, Object obj) {
        if ((i & 2) != 0) {
            str2 = null;
        }
        if ((i & 4) != 0) {
            num = null;
        }
        if ((i & 8) != 0) {
            num2 = null;
        }
        if ((i & 16) != 0) {
            num3 = null;
        }
        return invokeUindex(str, str2, num, num2, num3, function1, continuation);
    }

    /* JADX INFO: renamed from: com.phisher98.TorraStreamExtractorKt$invokeUindex$2 */
    /* JADX INFO: compiled from: TorraStreamExtractor.kt */
    @Metadata(d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u00012\u000b\u0010\u0002\u001a\u00070\u0003¢\u0006\u0002\b\u0004H\n"}, d2 = {"<anonymous>", "", "row", "Lorg/jsoup/nodes/Element;", "Lkotlin/jvm/internal/EnhancedNullability;"}, k = 3, mv = {2, 4, 0}, xi = 48)
    @DebugMetadata(c = "com.phisher98.TorraStreamExtractorKt$invokeUindex$2", f = "TorraStreamExtractor.kt", i = {0, 0, 0, 0, 0, 0, 0}, l = {498}, m = "invokeSuspend", n = {"row", "rowTitle", "magnet", "qualityMatch", "seeder", "fileSize", "formattedTitleName"}, nl = {497}, s = {"L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$6"}, v = 2)
    @SourceDebugExtension({"SMAP\nTorraStreamExtractor.kt\nKotlin\n*S Kotlin\n*F\n+ 1 TorraStreamExtractor.kt\ncom/phisher98/TorraStreamExtractorKt$invokeUindex$2\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n+ 3 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,823:1\n2945#2,3:824\n1#3:827\n*S KotlinDebug\n*F\n+ 1 TorraStreamExtractor.kt\ncom/phisher98/TorraStreamExtractorKt$invokeUindex$2\n*L\n468#1:824,3\n*E\n"})
    static final class C00572 extends SuspendLambda implements Function2<Element, Continuation<? super Unit>, Object> {
        final /* synthetic */ List<Regex> $episodePatterns;
        final /* synthetic */ Function1<ExtractorLink, Unit> $filtered;
        final /* synthetic */ boolean $isTv;
        /* synthetic */ Object L$0;
        Object L$1;
        Object L$2;
        Object L$3;
        Object L$4;
        Object L$5;
        Object L$6;
        Object L$7;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C00572(boolean z, List<Regex> list, Function1<? super ExtractorLink, Unit> function1, Continuation<? super C00572> continuation) {
            super(2, continuation);
            this.$isTv = z;
            this.$episodePatterns = list;
            this.$filtered = function1;
        }

        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            Continuation<Unit> c00572 = new C00572(this.$isTv, this.$episodePatterns, this.$filtered, continuation);
            c00572.L$0 = obj;
            return c00572;
        }

        public final Object invoke(Element element, Continuation<? super Unit> continuation) {
            return create(element, continuation).invokeSuspend(Unit.INSTANCE);
        }

        public final Object invokeSuspend(Object $result) {
            Object objNewExtractorLink;
            Function1<ExtractorLink, Unit> function1;
            boolean z;
            Element row = (Element) this.L$0;
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            switch (this.label) {
                case 0:
                    ResultKt.throwOnFailure($result);
                    String rowTitle = row.select("td:nth-child(2) > a:nth-child(2)").text();
                    String magnet = row.select("td:nth-child(2) > a:nth-child(1)").attr("href");
                    if (StringsKt.isBlank(rowTitle) || StringsKt.isBlank(magnet)) {
                        return Unit.INSTANCE;
                    }
                    if (this.$isTv && !this.$episodePatterns.isEmpty()) {
                        Iterable $this$none$iv = this.$episodePatterns;
                        if (($this$none$iv instanceof Collection) && ((Collection) $this$none$iv).isEmpty()) {
                            z = true;
                        } else {
                            Iterator it = $this$none$iv.iterator();
                            while (true) {
                                if (it.hasNext()) {
                                    Object element$iv = it.next();
                                    Regex it2 = (Regex) element$iv;
                                    if (it2.containsMatchIn(rowTitle)) {
                                        z = false;
                                    }
                                } else {
                                    z = true;
                                }
                            }
                        }
                        if (z) {
                            return Unit.INSTANCE;
                        }
                    }
                    MatchResult matchResultFind$default = Regex.find$default(new Regex("(2160p|1080p|720p)", RegexOption.IGNORE_CASE), rowTitle, 0, 2, (Object) null);
                    String qualityMatch = matchResultFind$default != null ? matchResultFind$default.getValue() : null;
                    String strReplace$default = StringsKt.replace$default(row.select("td:nth-child(4) > span").text(), ",", "", false, 4, (Object) null);
                    if (StringsKt.isBlank(strReplace$default)) {
                        strReplace$default = "0";
                    }
                    String seeder = strReplace$default;
                    String fileSize = row.select("td:nth-child(3)").text();
                    Regex qualityTermsRegex = new Regex("(WEBRip|WEB-DL|x265|x264|10bit|HEVC|H264)", RegexOption.IGNORE_CASE);
                    String tags = SequencesKt.joinToString$default(SequencesKt.distinct(SequencesKt.map(Regex.findAll$default(qualityTermsRegex, rowTitle, 0, 2, (Object) null), new Function1() { // from class: com.phisher98.TorraStreamExtractorKt$invokeUindex$2$$ExternalSyntheticLambda0
                        public final Object invoke(Object obj) {
                            return TorraStreamExtractorKt.C00572.invokeSuspend$lambda$2$0((MatchResult) obj);
                        }
                    })), " | ", (CharSequence) null, (CharSequence) null, 0, (CharSequence) null, (Function1) null, 62, (Object) null);
                    String formattedTitleName = StringsKt.trim("UIndex | " + tags + " | Seeder: " + seeder + " | FileSize: " + fileSize).toString();
                    Function1<ExtractorLink, Unit> function2 = this.$filtered;
                    String str = formattedTitleName;
                    if (StringsKt.isBlank(str)) {
                        str = rowTitle;
                    }
                    this.L$0 = SpillingKt.nullOutSpilledVariable(row);
                    this.L$1 = SpillingKt.nullOutSpilledVariable(rowTitle);
                    this.L$2 = SpillingKt.nullOutSpilledVariable(magnet);
                    this.L$3 = SpillingKt.nullOutSpilledVariable(qualityMatch);
                    this.L$4 = SpillingKt.nullOutSpilledVariable(seeder);
                    this.L$5 = SpillingKt.nullOutSpilledVariable(fileSize);
                    this.L$6 = SpillingKt.nullOutSpilledVariable(formattedTitleName);
                    this.L$7 = function2;
                    this.label = 1;
                    objNewExtractorLink = ExtractorApiKt.newExtractorLink("UIndex", str, magnet, ExtractorApiKt.getINFER_TYPE(), new AnonymousClass3(qualityMatch, null), (Continuation) this);
                    if (objNewExtractorLink == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    function1 = function2;
                    break;
                    break;
                case 1:
                    function1 = (Function1) this.L$7;
                    ResultKt.throwOnFailure($result);
                    objNewExtractorLink = $result;
                    break;
                default:
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            function1.invoke(objNewExtractorLink);
            return Unit.INSTANCE;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final String invokeSuspend$lambda$2$0(MatchResult it) {
            String upperCase = it.getValue().toUpperCase(Locale.ROOT);
            Intrinsics.checkNotNullExpressionValue(upperCase, "toUpperCase(...)");
            return upperCase;
        }

        /* JADX INFO: renamed from: com.phisher98.TorraStreamExtractorKt$invokeUindex$2$3, reason: invalid class name */
        /* JADX INFO: compiled from: TorraStreamExtractor.kt */
        @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lcom/lagradost/cloudstream3/utils/ExtractorLink;"}, k = 3, mv = {2, 4, 0}, xi = 48)
        @DebugMetadata(c = "com.phisher98.TorraStreamExtractorKt$invokeUindex$2$3", f = "TorraStreamExtractor.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, nl = {}, s = {}, v = 2)
        static final class AnonymousClass3 extends SuspendLambda implements Function2<ExtractorLink, Continuation<? super Unit>, Object> {
            final /* synthetic */ String $qualityMatch;
            private /* synthetic */ Object L$0;
            int label;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            AnonymousClass3(String str, Continuation<? super AnonymousClass3> continuation) {
                super(2, continuation);
                this.$qualityMatch = str;
            }

            public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                Continuation<Unit> anonymousClass3 = new AnonymousClass3(this.$qualityMatch, continuation);
                anonymousClass3.L$0 = obj;
                return anonymousClass3;
            }

            public final Object invoke(ExtractorLink extractorLink, Continuation<? super Unit> continuation) {
                return create(extractorLink, continuation).invokeSuspend(Unit.INSTANCE);
            }

            public final Object invokeSuspend(Object $result) {
                ExtractorLink $this$newExtractorLink = (ExtractorLink) this.L$0;
                IntrinsicsKt.getCOROUTINE_SUSPENDED();
                switch (this.label) {
                    case 0:
                        ResultKt.throwOnFailure($result);
                        $this$newExtractorLink.setQuality(ExtractorApiKt.getQualityFromName(this.$qualityMatch));
                        return Unit.INSTANCE;
                    default:
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
            }
        }
    }

    /* JADX WARN: Code duplicated, block: B:115:0x057c A[ADDED_TO_REGION, REMOVE] */
    /* JADX WARN: Code duplicated, block: B:118:0x05ae  */
    /* JADX WARN: Code duplicated, block: B:47:0x023f  */
    /* JADX WARN: Code duplicated, block: B:49:0x02ec A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:50:0x02ed  */
    /* JADX WARN: Code duplicated, block: B:54:0x032d  */
    /* JADX WARN: Code duplicated, block: B:56:0x0343  */
    /* JADX WARN: Code duplicated, block: B:57:0x0354  */
    /* JADX WARN: Code duplicated, block: B:59:0x035e  */
    /* JADX WARN: Code duplicated, block: B:60:0x036d  */
    /* JADX WARN: Code duplicated, block: B:62:0x037d  */
    /* JADX WARN: Code duplicated, block: B:65:0x038e  */
    /* JADX WARN: Code duplicated, block: B:7:0x0016  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:113:0x0547 -> B:114:0x0563). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:116:0x058b -> B:117:0x05a4). Please report as a decompilation issue!!! */
    /*  JADX ERROR: JadxOverflowException in pass: RegionMakerVisitor
        jadx.core.utils.exceptions.JadxOverflowException: Regions stack size limit reached
        	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:59)
        	at jadx.core.utils.ErrorsCounter.error(ErrorsCounter.java:31)
        	at jadx.core.dex.attributes.nodes.NotificationAttrNode.addError(NotificationAttrNode.java:19)
        */
    @org.jetbrains.annotations.Nullable
    public static final java.lang.Object invokeKnaben(@org.jetbrains.annotations.NotNull java.lang.String r39, boolean r40, @org.jetbrains.annotations.Nullable java.lang.String r41, @org.jetbrains.annotations.Nullable java.lang.Integer r42, @org.jetbrains.annotations.Nullable java.lang.Integer r43, @org.jetbrains.annotations.Nullable java.lang.Integer r44, @org.jetbrains.annotations.NotNull kotlin.jvm.functions.Function1<? super com.lagradost.cloudstream3.utils.ExtractorLink, kotlin.Unit> r45, @org.jetbrains.annotations.NotNull kotlin.coroutines.Continuation<? super kotlin.Unit> r46) {
        /*
            Method dump skipped, instruction units count: 1510
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.phisher98.TorraStreamExtractorKt.invokeKnaben(java.lang.String, boolean, java.lang.String, java.lang.Integer, java.lang.Integer, java.lang.Integer, kotlin.jvm.functions.Function1, kotlin.coroutines.Continuation):java.lang.Object");
    }

    public static /* synthetic */ Object invokeKnaben$default(String str, boolean z, String str2, Integer num, Integer num2, Integer num3, Function1 function1, Continuation continuation, int i, Object obj) {
        if ((i & 4) != 0) {
            str2 = null;
        }
        if ((i & 8) != 0) {
            num = null;
        }
        if ((i & 16) != 0) {
            num2 = null;
        }
        if ((i & 32) != 0) {
            num3 = null;
        }
        return invokeKnaben(str, z, str2, num, num2, num3, function1, continuation);
    }

    /* JADX WARN: Code duplicated, block: B:33:0x01a1  */
    /* JADX WARN: Code duplicated, block: B:35:0x01a4  */
    /* JADX WARN: Code duplicated, block: B:37:0x01aa  */
    /* JADX WARN: Code duplicated, block: B:39:0x01ea A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:40:0x01eb  */
    /* JADX WARN: Code duplicated, block: B:43:0x01f6  */
    /* JADX WARN: Code duplicated, block: B:7:0x001a  */
    @Nullable
    public static final Object invokeTorrentsDB(@NotNull String mainUrl, @Nullable String id, @Nullable Integer season, @Nullable Integer episode, @NotNull Function1<? super ExtractorLink, Unit> function1, @NotNull Continuation<? super Unit> continuation) {
        C00501 c00501;
        Integer num;
        String url;
        Object obj;
        Map headers;
        C00501 c00502;
        Object $result;
        Object obj2;
        Integer season2;
        Integer episode2;
        Function1<? super ExtractorLink, Unit> function2;
        String url2;
        String id2;
        Object safe;
        TorrentsDBResponse response;
        List<TorrentsDBStream> streams;
        C00512 c00512;
        if (continuation instanceof C00501) {
            c00501 = (C00501) continuation;
            if ((c00501.label & Integer.MIN_VALUE) != 0) {
                c00501.label -= Integer.MIN_VALUE;
            } else {
                c00501 = new C00501(continuation);
            }
        } else {
            c00501 = new C00501(continuation);
        }
        Object $result2 = c00501.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (c00501.label) {
            case 0:
                ResultKt.throwOnFailure($result2);
                if (id == null) {
                    return Unit.INSTANCE;
                }
                if (season == null) {
                    url = mainUrl + "/stream/movie/" + id + ".json";
                    num = episode;
                } else {
                    num = episode;
                    url = mainUrl + "/stream/series/" + id + ':' + season.intValue() + ':' + num + ".json";
                }
                Map headers2 = MapsKt.mapOf(new Pair[]{TuplesKt.to("Accept", "text/html,application/xhtml+xml,application/xml;q=0.9,image/avif,image/webp,image/apng,*/*;q=0.8"), TuplesKt.to("User-Agent", "Mozilla/5.0 (X11; Linux x86_64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/126.0.0.0 Safari/537.36")});
                Requests app = MainActivityKt.getApp();
                c00501.L$0 = SpillingKt.nullOutSpilledVariable(mainUrl);
                c00501.L$1 = SpillingKt.nullOutSpilledVariable(id);
                c00501.L$2 = SpillingKt.nullOutSpilledVariable(season);
                c00501.L$3 = SpillingKt.nullOutSpilledVariable(num);
                c00501.L$4 = function1;
                c00501.L$5 = SpillingKt.nullOutSpilledVariable(url);
                c00501.L$6 = SpillingKt.nullOutSpilledVariable(headers2);
                c00501.label = 1;
                String url3 = url;
                C00501 c00503 = c00501;
                obj = coroutine_suspended;
                Object obj3 = Requests.get$default(app, url3, headers2, (String) null, (Map) null, (Map) null, false, 0, (TimeUnit) null, 100L, (Interceptor) null, false, (ResponseParser) null, c00503, 3836, (Object) null);
                headers = headers2;
                c00502 = c00503;
                if (obj3 == obj) {
                    return obj;
                }
                $result = mainUrl;
                obj2 = obj3;
                season2 = season;
                episode2 = episode;
                function2 = function1;
                url2 = url3;
                id2 = id;
                NiceResponse this_$iv = (NiceResponse) obj2;
                try {
                    ResponseParser parser = this_$iv.getParser();
                    Intrinsics.checkNotNull(parser);
                    safe = parser.parseSafe(this_$iv.getText(), Reflection.getOrCreateKotlinClass(TorrentsDBResponse.class));
                    break;
                } catch (Exception e$iv) {
                    e$iv.printStackTrace();
                    safe = null;
                }
                response = (TorrentsDBResponse) safe;
                if (response == null) {
                    return Unit.INSTANCE;
                }
                streams = response.getStreams();
                if (streams != null) {
                    return Unit.INSTANCE;
                }
                c00512 = new C00512(function2, null);
                c00502.L$0 = SpillingKt.nullOutSpilledVariable($result);
                c00502.L$1 = SpillingKt.nullOutSpilledVariable(id2);
                c00502.L$2 = SpillingKt.nullOutSpilledVariable(season2);
                c00502.L$3 = SpillingKt.nullOutSpilledVariable(episode2);
                c00502.L$4 = SpillingKt.nullOutSpilledVariable(function2);
                c00502.L$5 = SpillingKt.nullOutSpilledVariable(url2);
                c00502.L$6 = SpillingKt.nullOutSpilledVariable(headers);
                c00502.L$7 = SpillingKt.nullOutSpilledVariable(response);
                c00502.label = 2;
                if (ParCollectionsKt.amap(streams, c00512, c00502) == obj) {
                    return obj;
                }
                return Unit.INSTANCE;
            case 1:
                Map headers3 = (Map) c00501.L$6;
                url2 = (String) c00501.L$5;
                function2 = (Function1) c00501.L$4;
                episode2 = (Integer) c00501.L$3;
                season2 = (Integer) c00501.L$2;
                String id3 = (String) c00501.L$1;
                Object mainUrl2 = (String) c00501.L$0;
                ResultKt.throwOnFailure($result2);
                c00502 = c00501;
                obj = coroutine_suspended;
                headers = headers3;
                $result = mainUrl2;
                id2 = id3;
                obj2 = $result2;
                NiceResponse this_$iv2 = (NiceResponse) obj2;
                ResponseParser parser2 = this_$iv2.getParser();
                Intrinsics.checkNotNull(parser2);
                safe = parser2.parseSafe(this_$iv2.getText(), Reflection.getOrCreateKotlinClass(TorrentsDBResponse.class));
                response = (TorrentsDBResponse) safe;
                if (response == null) {
                    return Unit.INSTANCE;
                }
                streams = response.getStreams();
                if (streams != null) {
                    return Unit.INSTANCE;
                }
                c00512 = new C00512(function2, null);
                c00502.L$0 = SpillingKt.nullOutSpilledVariable($result);
                c00502.L$1 = SpillingKt.nullOutSpilledVariable(id2);
                c00502.L$2 = SpillingKt.nullOutSpilledVariable(season2);
                c00502.L$3 = SpillingKt.nullOutSpilledVariable(episode2);
                c00502.L$4 = SpillingKt.nullOutSpilledVariable(function2);
                c00502.L$5 = SpillingKt.nullOutSpilledVariable(url2);
                c00502.L$6 = SpillingKt.nullOutSpilledVariable(headers);
                c00502.L$7 = SpillingKt.nullOutSpilledVariable(response);
                c00502.label = 2;
                if (ParCollectionsKt.amap(streams, c00512, c00502) == obj) {
                    return obj;
                }
                return Unit.INSTANCE;
            case 2:
                ResultKt.throwOnFailure($result2);
                return Unit.INSTANCE;
            default:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    public static /* synthetic */ Object invokeTorrentsDB$default(String str, String str2, Integer num, Integer num2, Function1 function1, Continuation continuation, int i, Object obj) {
        if ((i & 2) != 0) {
            str2 = null;
        }
        if ((i & 4) != 0) {
            num = null;
        }
        if ((i & 8) != 0) {
            num2 = null;
        }
        return invokeTorrentsDB(str, str2, num, num2, function1, continuation);
    }

    /* JADX INFO: renamed from: com.phisher98.TorraStreamExtractorKt$invokeTorrentsDB$2 */
    /* JADX INFO: compiled from: TorraStreamExtractor.kt */
    @Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n"}, d2 = {"<anonymous>", "", "stream", "Lcom/phisher98/TorrentsDBStream;"}, k = 3, mv = {2, 4, 0}, xi = 48)
    @DebugMetadata(c = "com.phisher98.TorraStreamExtractorKt$invokeTorrentsDB$2", f = "TorraStreamExtractor.kt", i = {0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 1, 1, 1, 1, 1}, l = {637, 640}, m = "invokeSuspend", n = {"stream", "title", "qualityMatch", "tags", "seeder", "provider", "formattedTitle", "stream", "title", "qualityMatch", "tags", "seeder", "provider", "formattedTitle", "magnet"}, nl = {639, 639}, s = {"L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$6", "L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$6", "L$7"}, v = 2)
    static final class C00512 extends SuspendLambda implements Function2<TorrentsDBStream, Continuation<? super Unit>, Object> {
        final /* synthetic */ Function1<ExtractorLink, Unit> $callback;
        /* synthetic */ Object L$0;
        Object L$1;
        Object L$2;
        Object L$3;
        Object L$4;
        Object L$5;
        Object L$6;
        Object L$7;
        Object L$8;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C00512(Function1<? super ExtractorLink, Unit> function1, Continuation<? super C00512> continuation) {
            super(2, continuation);
            this.$callback = function1;
        }

        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            Continuation<Unit> c00512 = new C00512(this.$callback, continuation);
            c00512.L$0 = obj;
            return c00512;
        }

        public final Object invoke(TorrentsDBStream torrentsDBStream, Continuation<? super Unit> continuation) {
            return create(torrentsDBStream, continuation).invokeSuspend(Unit.INSTANCE);
        }

        /* JADX WARN: Code duplicated, block: B:42:0x01d0 A[RETURN] */
        /* JADX WARN: Code duplicated, block: B:43:0x01d1  */
        public final Object invokeSuspend(Object $result) {
            String formattedTitle;
            String qualityMatch;
            String seeder;
            String provider;
            Object objGenerateMagnetLink;
            String seeder2;
            String qualityMatch2;
            String provider2;
            String tags;
            String formattedTitle2;
            List groupValues;
            String str;
            List groupValues2;
            String value;
            Function1<ExtractorLink, Unit> function1;
            Object objNewExtractorLink;
            Function1<ExtractorLink, Unit> function2;
            TorrentsDBStream stream = (TorrentsDBStream) this.L$0;
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            switch (this.label) {
                case 0:
                    ResultKt.throwOnFailure($result);
                    formattedTitle = stream.getTitle();
                    if (formattedTitle == null) {
                        formattedTitle = "";
                    }
                    MatchResult matchResultFind$default = Regex.find$default(new Regex("(2160p|1080p|720p)", RegexOption.IGNORE_CASE), formattedTitle, 0, 2, (Object) null);
                    if (matchResultFind$default == null || (value = matchResultFind$default.getValue()) == null) {
                        qualityMatch = null;
                    } else {
                        qualityMatch = value.toLowerCase(Locale.ROOT);
                        Intrinsics.checkNotNullExpressionValue(qualityMatch, "toLowerCase(...)");
                    }
                    String tags2 = SequencesKt.joinToString$default(SequencesKt.distinct(SequencesKt.map(Regex.findAll$default(new Regex("(2160p|1080p|720p|WEBRip|WEB-DL|x265|x264|10bit|HEVC|H264)", RegexOption.IGNORE_CASE), formattedTitle, 0, 2, (Object) null), new Function1() { // from class: com.phisher98.TorraStreamExtractorKt$invokeTorrentsDB$2$$ExternalSyntheticLambda0
                        public final Object invoke(Object obj) {
                            return TorraStreamExtractorKt.C00512.invokeSuspend$lambda$0((MatchResult) obj);
                        }
                    })), " | ", (CharSequence) null, (CharSequence) null, 0, (CharSequence) null, (Function1) null, 62, (Object) null);
                    MatchResult matchResultFind$default2 = Regex.find$default(new Regex("👤\\s*(\\d+)"), formattedTitle, 0, 2, (Object) null);
                    if (matchResultFind$default2 == null || (groupValues2 = matchResultFind$default2.getGroupValues()) == null || (seeder = (String) CollectionsKt.getOrNull(groupValues2, 1)) == null) {
                        seeder = "0";
                    }
                    MatchResult matchResultFind$default3 = Regex.find$default(new Regex("⚙️\\s*([^\\n]+)"), formattedTitle, 0, 2, (Object) null);
                    if (matchResultFind$default3 == null || (groupValues = matchResultFind$default3.getGroupValues()) == null || (str = (String) CollectionsKt.getOrNull(groupValues, 1)) == null || (provider = StringsKt.trim(str).toString()) == null) {
                        provider = "Unknown";
                    }
                    String formattedTitle3 = "TorrentsDB | " + tags2 + " | Seeder: " + seeder + " | Provider: " + provider;
                    List<String> sources = stream.getSources();
                    if (sources == null) {
                        sources = CollectionsKt.emptyList();
                    }
                    this.L$0 = SpillingKt.nullOutSpilledVariable(stream);
                    this.L$1 = SpillingKt.nullOutSpilledVariable(formattedTitle);
                    this.L$2 = qualityMatch;
                    this.L$3 = SpillingKt.nullOutSpilledVariable(tags2);
                    this.L$4 = SpillingKt.nullOutSpilledVariable(seeder);
                    this.L$5 = SpillingKt.nullOutSpilledVariable(provider);
                    this.L$6 = formattedTitle3;
                    this.label = 1;
                    objGenerateMagnetLink = TorraStreamUtilsKt.generateMagnetLink(sources, stream.getInfoHash(), (Continuation) this);
                    if (objGenerateMagnetLink == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    String str2 = seeder;
                    seeder2 = qualityMatch;
                    qualityMatch2 = provider;
                    provider2 = tags2;
                    tags = str2;
                    formattedTitle2 = formattedTitle3;
                    String magnet = (String) objGenerateMagnetLink;
                    function1 = this.$callback;
                    this.L$0 = SpillingKt.nullOutSpilledVariable(stream);
                    this.L$1 = SpillingKt.nullOutSpilledVariable(formattedTitle);
                    this.L$2 = SpillingKt.nullOutSpilledVariable(seeder2);
                    this.L$3 = SpillingKt.nullOutSpilledVariable(provider2);
                    this.L$4 = SpillingKt.nullOutSpilledVariable(tags);
                    this.L$5 = SpillingKt.nullOutSpilledVariable(qualityMatch2);
                    this.L$6 = SpillingKt.nullOutSpilledVariable(formattedTitle2);
                    this.L$7 = SpillingKt.nullOutSpilledVariable(magnet);
                    this.L$8 = function1;
                    this.label = 2;
                    objNewExtractorLink = ExtractorApiKt.newExtractorLink("TorrentsDB", formattedTitle2, magnet, ExtractorApiKt.getINFER_TYPE(), new AnonymousClass1(seeder2, null), (Continuation) this);
                    if (objNewExtractorLink == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    function2 = function1;
                    function2.invoke(objNewExtractorLink);
                    return Unit.INSTANCE;
                case 1:
                    String formattedTitle4 = (String) this.L$6;
                    qualityMatch2 = (String) this.L$5;
                    tags = (String) this.L$4;
                    provider2 = (String) this.L$3;
                    seeder2 = (String) this.L$2;
                    String title = (String) this.L$1;
                    ResultKt.throwOnFailure($result);
                    formattedTitle2 = formattedTitle4;
                    formattedTitle = title;
                    objGenerateMagnetLink = $result;
                    String magnet2 = (String) objGenerateMagnetLink;
                    function1 = this.$callback;
                    this.L$0 = SpillingKt.nullOutSpilledVariable(stream);
                    this.L$1 = SpillingKt.nullOutSpilledVariable(formattedTitle);
                    this.L$2 = SpillingKt.nullOutSpilledVariable(seeder2);
                    this.L$3 = SpillingKt.nullOutSpilledVariable(provider2);
                    this.L$4 = SpillingKt.nullOutSpilledVariable(tags);
                    this.L$5 = SpillingKt.nullOutSpilledVariable(qualityMatch2);
                    this.L$6 = SpillingKt.nullOutSpilledVariable(formattedTitle2);
                    this.L$7 = SpillingKt.nullOutSpilledVariable(magnet2);
                    this.L$8 = function1;
                    this.label = 2;
                    objNewExtractorLink = ExtractorApiKt.newExtractorLink("TorrentsDB", formattedTitle2, magnet2, ExtractorApiKt.getINFER_TYPE(), new AnonymousClass1(seeder2, null), (Continuation) this);
                    if (objNewExtractorLink == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    function2 = function1;
                    function2.invoke(objNewExtractorLink);
                    return Unit.INSTANCE;
                case 2:
                    function2 = (Function1) this.L$8;
                    ResultKt.throwOnFailure($result);
                    objNewExtractorLink = $result;
                    function2.invoke(objNewExtractorLink);
                    return Unit.INSTANCE;
                default:
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
        }

        static final String invokeSuspend$lambda$0(MatchResult it) {
            String upperCase = it.getValue().toUpperCase(Locale.ROOT);
            Intrinsics.checkNotNullExpressionValue(upperCase, "toUpperCase(...)");
            return upperCase;
        }

        /* JADX INFO: renamed from: com.phisher98.TorraStreamExtractorKt$invokeTorrentsDB$2$1, reason: invalid class name */
        /* JADX INFO: compiled from: TorraStreamExtractor.kt */
        @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lcom/lagradost/cloudstream3/utils/ExtractorLink;"}, k = 3, mv = {2, 4, 0}, xi = 48)
        @DebugMetadata(c = "com.phisher98.TorraStreamExtractorKt$invokeTorrentsDB$2$1", f = "TorraStreamExtractor.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, nl = {}, s = {}, v = 2)
        static final class AnonymousClass1 extends SuspendLambda implements Function2<ExtractorLink, Continuation<? super Unit>, Object> {
            final /* synthetic */ String $qualityMatch;
            private /* synthetic */ Object L$0;
            int label;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            AnonymousClass1(String str, Continuation<? super AnonymousClass1> continuation) {
                super(2, continuation);
                this.$qualityMatch = str;
            }

            public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                Continuation<Unit> anonymousClass1 = new AnonymousClass1(this.$qualityMatch, continuation);
                anonymousClass1.L$0 = obj;
                return anonymousClass1;
            }

            public final Object invoke(ExtractorLink extractorLink, Continuation<? super Unit> continuation) {
                return create(extractorLink, continuation).invokeSuspend(Unit.INSTANCE);
            }

            public final Object invokeSuspend(Object $result) {
                ExtractorLink $this$newExtractorLink = (ExtractorLink) this.L$0;
                IntrinsicsKt.getCOROUTINE_SUSPENDED();
                switch (this.label) {
                    case 0:
                        ResultKt.throwOnFailure($result);
                        $this$newExtractorLink.setReferer("");
                        $this$newExtractorLink.setQuality(ExtractorApiKt.getQualityFromName(this.$qualityMatch));
                        return Unit.INSTANCE;
                    default:
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
            }
        }
    }

    /* JADX WARN: Code duplicated, block: B:33:0x0195  */
    /* JADX WARN: Code duplicated, block: B:35:0x0198  */
    /* JADX WARN: Code duplicated, block: B:37:0x019e  */
    /* JADX WARN: Code duplicated, block: B:39:0x01dd A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:40:0x01de  */
    /* JADX WARN: Code duplicated, block: B:43:0x01e7  */
    /* JADX WARN: Code duplicated, block: B:7:0x0018  */
    @Nullable
    public static final Object invokeTorrentsDBAnime(@NotNull String mainUrl, @Nullable Integer id, @Nullable Integer season, @Nullable Integer episode, @NotNull Function1<? super ExtractorLink, Unit> function1, @NotNull Continuation<? super Unit> continuation) {
        C00531 c00531;
        Integer num;
        String url;
        Object obj;
        int i;
        C00531 c00532;
        Object $result;
        Object obj2;
        String url2;
        Map headers;
        Integer id2;
        Integer season2;
        Integer episode2;
        Function1<? super ExtractorLink, Unit> function2;
        Object safe;
        TorrentsDBResponse response;
        List<TorrentsDBStream> streams;
        C00542 c00542;
        if (continuation instanceof C00531) {
            c00531 = (C00531) continuation;
            if ((c00531.label & Integer.MIN_VALUE) != 0) {
                c00531.label -= Integer.MIN_VALUE;
            } else {
                c00531 = new C00531(continuation);
            }
        } else {
            c00531 = new C00531(continuation);
        }
        Object $result2 = c00531.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (c00531.label) {
            case 0:
                ResultKt.throwOnFailure($result2);
                if (id == null) {
                    return Unit.INSTANCE;
                }
                if (season == null) {
                    url = mainUrl + "/stream/movie/kitsu:" + id.intValue() + ".json";
                    num = episode;
                } else {
                    num = episode;
                    url = mainUrl + "/stream/series/kitsu:" + id.intValue() + ':' + num + ".json";
                }
                Map headers2 = MapsKt.mapOf(new Pair[]{TuplesKt.to("Accept", "text/html,application/xhtml+xml,application/xml;q=0.9,image/avif,image/webp,image/apng,*/*;q=0.8"), TuplesKt.to("User-Agent", "Mozilla/5.0 (X11; Linux x86_64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/126.0.0.0 Safari/537.36")});
                Requests app = MainActivityKt.getApp();
                c00531.L$0 = SpillingKt.nullOutSpilledVariable(mainUrl);
                c00531.L$1 = SpillingKt.nullOutSpilledVariable(id);
                c00531.L$2 = SpillingKt.nullOutSpilledVariable(season);
                c00531.L$3 = SpillingKt.nullOutSpilledVariable(num);
                c00531.L$4 = function1;
                c00531.L$5 = SpillingKt.nullOutSpilledVariable(url);
                c00531.L$6 = SpillingKt.nullOutSpilledVariable(headers2);
                c00531.label = 1;
                String url3 = url;
                C00531 c00533 = c00531;
                obj = coroutine_suspended;
                i = 2;
                Object obj3 = Requests.get$default(app, url3, headers2, (String) null, (Map) null, (Map) null, false, 0, (TimeUnit) null, 100L, (Interceptor) null, false, (ResponseParser) null, c00533, 3836, (Object) null);
                c00532 = c00533;
                if (obj3 == obj) {
                    return obj;
                }
                $result = mainUrl;
                obj2 = obj3;
                url2 = url3;
                headers = headers2;
                id2 = id;
                season2 = season;
                episode2 = episode;
                function2 = function1;
                NiceResponse this_$iv = (NiceResponse) obj2;
                try {
                    ResponseParser parser = this_$iv.getParser();
                    Intrinsics.checkNotNull(parser);
                    safe = parser.parseSafe(this_$iv.getText(), Reflection.getOrCreateKotlinClass(TorrentsDBResponse.class));
                    break;
                } catch (Exception e$iv) {
                    e$iv.printStackTrace();
                    safe = null;
                }
                response = (TorrentsDBResponse) safe;
                if (response == null) {
                    return Unit.INSTANCE;
                }
                streams = response.getStreams();
                if (streams != null) {
                    return Unit.INSTANCE;
                }
                c00542 = new C00542(function2, null);
                c00532.L$0 = SpillingKt.nullOutSpilledVariable($result);
                c00532.L$1 = SpillingKt.nullOutSpilledVariable(id2);
                c00532.L$2 = SpillingKt.nullOutSpilledVariable(season2);
                c00532.L$3 = SpillingKt.nullOutSpilledVariable(episode2);
                c00532.L$4 = SpillingKt.nullOutSpilledVariable(function2);
                c00532.L$5 = SpillingKt.nullOutSpilledVariable(url2);
                c00532.L$6 = SpillingKt.nullOutSpilledVariable(headers);
                c00532.L$7 = SpillingKt.nullOutSpilledVariable(response);
                c00532.label = i;
                if (ParCollectionsKt.amap(streams, c00542, c00532) == obj) {
                    return obj;
                }
                return Unit.INSTANCE;
            case 1:
                headers = (Map) c00531.L$6;
                String url4 = (String) c00531.L$5;
                function2 = (Function1) c00531.L$4;
                episode2 = (Integer) c00531.L$3;
                season2 = (Integer) c00531.L$2;
                id2 = (Integer) c00531.L$1;
                Object mainUrl2 = (String) c00531.L$0;
                ResultKt.throwOnFailure($result2);
                c00532 = c00531;
                obj = coroutine_suspended;
                url2 = url4;
                i = 2;
                $result = mainUrl2;
                obj2 = $result2;
                NiceResponse this_$iv2 = (NiceResponse) obj2;
                ResponseParser parser2 = this_$iv2.getParser();
                Intrinsics.checkNotNull(parser2);
                safe = parser2.parseSafe(this_$iv2.getText(), Reflection.getOrCreateKotlinClass(TorrentsDBResponse.class));
                response = (TorrentsDBResponse) safe;
                if (response == null) {
                    return Unit.INSTANCE;
                }
                streams = response.getStreams();
                if (streams != null) {
                    return Unit.INSTANCE;
                }
                c00542 = new C00542(function2, null);
                c00532.L$0 = SpillingKt.nullOutSpilledVariable($result);
                c00532.L$1 = SpillingKt.nullOutSpilledVariable(id2);
                c00532.L$2 = SpillingKt.nullOutSpilledVariable(season2);
                c00532.L$3 = SpillingKt.nullOutSpilledVariable(episode2);
                c00532.L$4 = SpillingKt.nullOutSpilledVariable(function2);
                c00532.L$5 = SpillingKt.nullOutSpilledVariable(url2);
                c00532.L$6 = SpillingKt.nullOutSpilledVariable(headers);
                c00532.L$7 = SpillingKt.nullOutSpilledVariable(response);
                c00532.label = i;
                if (ParCollectionsKt.amap(streams, c00542, c00532) == obj) {
                    return obj;
                }
                return Unit.INSTANCE;
            case 2:
                ResultKt.throwOnFailure($result2);
                return Unit.INSTANCE;
            default:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    public static /* synthetic */ Object invokeTorrentsDBAnime$default(String str, Integer num, Integer num2, Integer num3, Function1 function1, Continuation continuation, int i, Object obj) {
        if ((i & 2) != 0) {
            num = null;
        }
        if ((i & 4) != 0) {
            num2 = null;
        }
        if ((i & 8) != 0) {
            num3 = null;
        }
        return invokeTorrentsDBAnime(str, num, num2, num3, function1, continuation);
    }

    /* JADX INFO: renamed from: com.phisher98.TorraStreamExtractorKt$invokeTorrentsDBAnime$2 */
    /* JADX INFO: compiled from: TorraStreamExtractor.kt */
    @Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n"}, d2 = {"<anonymous>", "", "stream", "Lcom/phisher98/TorrentsDBStream;"}, k = 3, mv = {2, 4, 0}, xi = 48)
    @DebugMetadata(c = "com.phisher98.TorraStreamExtractorKt$invokeTorrentsDBAnime$2", f = "TorraStreamExtractor.kt", i = {0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 1, 1, 1, 1, 1}, l = {686, 689}, m = "invokeSuspend", n = {"stream", "title", "qualityMatch", "tags", "seeder", "provider", "formattedTitle", "stream", "title", "qualityMatch", "tags", "seeder", "provider", "formattedTitle", "magnet"}, nl = {688, 688}, s = {"L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$6", "L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$6", "L$7"}, v = 2)
    static final class C00542 extends SuspendLambda implements Function2<TorrentsDBStream, Continuation<? super Unit>, Object> {
        final /* synthetic */ Function1<ExtractorLink, Unit> $filtered;
        /* synthetic */ Object L$0;
        Object L$1;
        Object L$2;
        Object L$3;
        Object L$4;
        Object L$5;
        Object L$6;
        Object L$7;
        Object L$8;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C00542(Function1<? super ExtractorLink, Unit> function1, Continuation<? super C00542> continuation) {
            super(2, continuation);
            this.$filtered = function1;
        }

        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            Continuation<Unit> c00542 = new C00542(this.$filtered, continuation);
            c00542.L$0 = obj;
            return c00542;
        }

        public final Object invoke(TorrentsDBStream torrentsDBStream, Continuation<? super Unit> continuation) {
            return create(torrentsDBStream, continuation).invokeSuspend(Unit.INSTANCE);
        }

        /* JADX WARN: Code duplicated, block: B:42:0x01d0 A[RETURN] */
        /* JADX WARN: Code duplicated, block: B:43:0x01d1  */
        public final Object invokeSuspend(Object $result) {
            String formattedTitle;
            String qualityMatch;
            String seeder;
            String provider;
            Object objGenerateMagnetLink;
            String seeder2;
            String qualityMatch2;
            String provider2;
            String tags;
            String formattedTitle2;
            List groupValues;
            String str;
            List groupValues2;
            String value;
            Function1<ExtractorLink, Unit> function1;
            Object objNewExtractorLink;
            Function1<ExtractorLink, Unit> function2;
            TorrentsDBStream stream = (TorrentsDBStream) this.L$0;
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            switch (this.label) {
                case 0:
                    ResultKt.throwOnFailure($result);
                    formattedTitle = stream.getTitle();
                    if (formattedTitle == null) {
                        formattedTitle = "";
                    }
                    MatchResult matchResultFind$default = Regex.find$default(new Regex("(2160p|1080p|720p)", RegexOption.IGNORE_CASE), formattedTitle, 0, 2, (Object) null);
                    if (matchResultFind$default == null || (value = matchResultFind$default.getValue()) == null) {
                        qualityMatch = null;
                    } else {
                        qualityMatch = value.toLowerCase(Locale.ROOT);
                        Intrinsics.checkNotNullExpressionValue(qualityMatch, "toLowerCase(...)");
                    }
                    String tags2 = SequencesKt.joinToString$default(SequencesKt.distinct(SequencesKt.map(Regex.findAll$default(new Regex("(2160p|1080p|720p|WEBRip|WEB-DL|x265|x264|10bit|HEVC|H264)", RegexOption.IGNORE_CASE), formattedTitle, 0, 2, (Object) null), new Function1() { // from class: com.phisher98.TorraStreamExtractorKt$invokeTorrentsDBAnime$2$$ExternalSyntheticLambda0
                        public final Object invoke(Object obj) {
                            return TorraStreamExtractorKt.C00542.invokeSuspend$lambda$0((MatchResult) obj);
                        }
                    })), " | ", (CharSequence) null, (CharSequence) null, 0, (CharSequence) null, (Function1) null, 62, (Object) null);
                    MatchResult matchResultFind$default2 = Regex.find$default(new Regex("👤\\s*(\\d+)"), formattedTitle, 0, 2, (Object) null);
                    if (matchResultFind$default2 == null || (groupValues2 = matchResultFind$default2.getGroupValues()) == null || (seeder = (String) CollectionsKt.getOrNull(groupValues2, 1)) == null) {
                        seeder = "0";
                    }
                    MatchResult matchResultFind$default3 = Regex.find$default(new Regex("⚙️\\s*([^\\n]+)"), formattedTitle, 0, 2, (Object) null);
                    if (matchResultFind$default3 == null || (groupValues = matchResultFind$default3.getGroupValues()) == null || (str = (String) CollectionsKt.getOrNull(groupValues, 1)) == null || (provider = StringsKt.trim(str).toString()) == null) {
                        provider = "Unknown";
                    }
                    String formattedTitle3 = "TorrentsDB | " + tags2 + " | Seeder: " + seeder + " | Provider: " + provider;
                    List<String> sources = stream.getSources();
                    if (sources == null) {
                        sources = CollectionsKt.emptyList();
                    }
                    this.L$0 = SpillingKt.nullOutSpilledVariable(stream);
                    this.L$1 = SpillingKt.nullOutSpilledVariable(formattedTitle);
                    this.L$2 = qualityMatch;
                    this.L$3 = SpillingKt.nullOutSpilledVariable(tags2);
                    this.L$4 = SpillingKt.nullOutSpilledVariable(seeder);
                    this.L$5 = SpillingKt.nullOutSpilledVariable(provider);
                    this.L$6 = formattedTitle3;
                    this.label = 1;
                    objGenerateMagnetLink = TorraStreamUtilsKt.generateMagnetLink(sources, stream.getInfoHash(), (Continuation) this);
                    if (objGenerateMagnetLink == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    String str2 = seeder;
                    seeder2 = qualityMatch;
                    qualityMatch2 = provider;
                    provider2 = tags2;
                    tags = str2;
                    formattedTitle2 = formattedTitle3;
                    String magnet = (String) objGenerateMagnetLink;
                    function1 = this.$filtered;
                    this.L$0 = SpillingKt.nullOutSpilledVariable(stream);
                    this.L$1 = SpillingKt.nullOutSpilledVariable(formattedTitle);
                    this.L$2 = SpillingKt.nullOutSpilledVariable(seeder2);
                    this.L$3 = SpillingKt.nullOutSpilledVariable(provider2);
                    this.L$4 = SpillingKt.nullOutSpilledVariable(tags);
                    this.L$5 = SpillingKt.nullOutSpilledVariable(qualityMatch2);
                    this.L$6 = SpillingKt.nullOutSpilledVariable(formattedTitle2);
                    this.L$7 = SpillingKt.nullOutSpilledVariable(magnet);
                    this.L$8 = function1;
                    this.label = 2;
                    objNewExtractorLink = ExtractorApiKt.newExtractorLink("TorrentsDB", formattedTitle2, magnet, ExtractorApiKt.getINFER_TYPE(), new AnonymousClass1(seeder2, null), (Continuation) this);
                    if (objNewExtractorLink == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    function2 = function1;
                    function2.invoke(objNewExtractorLink);
                    return Unit.INSTANCE;
                case 1:
                    String formattedTitle4 = (String) this.L$6;
                    qualityMatch2 = (String) this.L$5;
                    tags = (String) this.L$4;
                    provider2 = (String) this.L$3;
                    seeder2 = (String) this.L$2;
                    String title = (String) this.L$1;
                    ResultKt.throwOnFailure($result);
                    formattedTitle2 = formattedTitle4;
                    formattedTitle = title;
                    objGenerateMagnetLink = $result;
                    String magnet2 = (String) objGenerateMagnetLink;
                    function1 = this.$filtered;
                    this.L$0 = SpillingKt.nullOutSpilledVariable(stream);
                    this.L$1 = SpillingKt.nullOutSpilledVariable(formattedTitle);
                    this.L$2 = SpillingKt.nullOutSpilledVariable(seeder2);
                    this.L$3 = SpillingKt.nullOutSpilledVariable(provider2);
                    this.L$4 = SpillingKt.nullOutSpilledVariable(tags);
                    this.L$5 = SpillingKt.nullOutSpilledVariable(qualityMatch2);
                    this.L$6 = SpillingKt.nullOutSpilledVariable(formattedTitle2);
                    this.L$7 = SpillingKt.nullOutSpilledVariable(magnet2);
                    this.L$8 = function1;
                    this.label = 2;
                    objNewExtractorLink = ExtractorApiKt.newExtractorLink("TorrentsDB", formattedTitle2, magnet2, ExtractorApiKt.getINFER_TYPE(), new AnonymousClass1(seeder2, null), (Continuation) this);
                    if (objNewExtractorLink == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    function2 = function1;
                    function2.invoke(objNewExtractorLink);
                    return Unit.INSTANCE;
                case 2:
                    function2 = (Function1) this.L$8;
                    ResultKt.throwOnFailure($result);
                    objNewExtractorLink = $result;
                    function2.invoke(objNewExtractorLink);
                    return Unit.INSTANCE;
                default:
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
        }

        static final String invokeSuspend$lambda$0(MatchResult it) {
            String upperCase = it.getValue().toUpperCase(Locale.ROOT);
            Intrinsics.checkNotNullExpressionValue(upperCase, "toUpperCase(...)");
            return upperCase;
        }

        /* JADX INFO: renamed from: com.phisher98.TorraStreamExtractorKt$invokeTorrentsDBAnime$2$1, reason: invalid class name */
        /* JADX INFO: compiled from: TorraStreamExtractor.kt */
        @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lcom/lagradost/cloudstream3/utils/ExtractorLink;"}, k = 3, mv = {2, 4, 0}, xi = 48)
        @DebugMetadata(c = "com.phisher98.TorraStreamExtractorKt$invokeTorrentsDBAnime$2$1", f = "TorraStreamExtractor.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, nl = {}, s = {}, v = 2)
        static final class AnonymousClass1 extends SuspendLambda implements Function2<ExtractorLink, Continuation<? super Unit>, Object> {
            final /* synthetic */ String $qualityMatch;
            private /* synthetic */ Object L$0;
            int label;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            AnonymousClass1(String str, Continuation<? super AnonymousClass1> continuation) {
                super(2, continuation);
                this.$qualityMatch = str;
            }

            public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                Continuation<Unit> anonymousClass1 = new AnonymousClass1(this.$qualityMatch, continuation);
                anonymousClass1.L$0 = obj;
                return anonymousClass1;
            }

            public final Object invoke(ExtractorLink extractorLink, Continuation<? super Unit> continuation) {
                return create(extractorLink, continuation).invokeSuspend(Unit.INSTANCE);
            }

            public final Object invokeSuspend(Object $result) {
                ExtractorLink $this$newExtractorLink = (ExtractorLink) this.L$0;
                IntrinsicsKt.getCOROUTINE_SUSPENDED();
                switch (this.label) {
                    case 0:
                        ResultKt.throwOnFailure($result);
                        $this$newExtractorLink.setReferer("");
                        $this$newExtractorLink.setQuality(ExtractorApiKt.getQualityFromName(this.$qualityMatch));
                        return Unit.INSTANCE;
                    default:
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
            }
        }
    }

    /* JADX WARN: Code duplicated, block: B:34:0x01f6  */
    /* JADX WARN: Code duplicated, block: B:36:0x020f  */
    /* JADX WARN: Code duplicated, block: B:37:0x0243  */
    /* JADX WARN: Code duplicated, block: B:40:0x0257  */
    /* JADX WARN: Code duplicated, block: B:41:0x026b  */
    /* JADX WARN: Code duplicated, block: B:44:0x02ac  */
    /* JADX WARN: Code duplicated, block: B:45:0x02b1  */
    /* JADX WARN: Code duplicated, block: B:48:0x02ca  */
    /* JADX WARN: Code duplicated, block: B:51:0x02d9  */
    /* JADX WARN: Code duplicated, block: B:53:0x02dc  */
    /* JADX WARN: Code duplicated, block: B:54:0x02f2  */
    /* JADX WARN: Code duplicated, block: B:56:0x02f5  */
    /* JADX WARN: Code duplicated, block: B:57:0x030e  */
    /* JADX WARN: Code duplicated, block: B:60:0x0314  */
    /* JADX WARN: Code duplicated, block: B:61:0x032c  */
    /* JADX WARN: Code duplicated, block: B:64:0x0351  */
    /* JADX WARN: Code duplicated, block: B:68:0x0362 A[ADDED_TO_REGION, REMOVE] */
    /* JADX WARN: Code duplicated, block: B:72:0x0371  */
    /* JADX WARN: Code duplicated, block: B:73:0x039f  */
    /* JADX WARN: Code duplicated, block: B:76:0x03ad  */
    /* JADX WARN: Code duplicated, block: B:77:0x03b0  */
    /* JADX WARN: Code duplicated, block: B:7:0x001a  */
    /* JADX WARN: Code duplicated, block: B:81:0x03d9  */
    /* JADX WARN: Code duplicated, block: B:84:0x048e A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:85:0x048f  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:85:0x048f -> B:86:0x04b3). Please report as a decompilation issue!!! */
    /*  JADX ERROR: JadxOverflowException in pass: RegionMakerVisitor
        jadx.core.utils.exceptions.JadxOverflowException: Regions stack size limit reached
        	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:59)
        	at jadx.core.utils.ErrorsCounter.error(ErrorsCounter.java:31)
        	at jadx.core.dex.attributes.nodes.NotificationAttrNode.addError(NotificationAttrNode.java:19)
        */
    @org.jetbrains.annotations.Nullable
    public static final java.lang.Object invokeMeteorDebian(@org.jetbrains.annotations.NotNull java.lang.String r40, @org.jetbrains.annotations.Nullable java.lang.String r41, @org.jetbrains.annotations.Nullable java.lang.Integer r42, @org.jetbrains.annotations.Nullable java.lang.Integer r43, @org.jetbrains.annotations.NotNull kotlin.jvm.functions.Function1<? super com.lagradost.cloudstream3.utils.ExtractorLink, kotlin.Unit> r44, @org.jetbrains.annotations.NotNull kotlin.coroutines.Continuation<? super kotlin.Unit> r45) {
        /*
            Method dump skipped, instruction units count: 1266
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.phisher98.TorraStreamExtractorKt.invokeMeteorDebian(java.lang.String, java.lang.String, java.lang.Integer, java.lang.Integer, kotlin.jvm.functions.Function1, kotlin.coroutines.Continuation):java.lang.Object");
    }

    public static /* synthetic */ Object invokeMeteorDebian$default(String str, String str2, Integer num, Integer num2, Function1 function1, Continuation continuation, int i, Object obj) {
        if ((i & 2) != 0) {
            str2 = null;
        }
        if ((i & 4) != 0) {
            num = null;
        }
        if ((i & 8) != 0) {
            num2 = null;
        }
        return invokeMeteorDebian(str, str2, num, num2, function1, continuation);
    }

    /* JADX WARN: Code duplicated, block: B:34:0x01f0  */
    /* JADX WARN: Code duplicated, block: B:36:0x0209  */
    /* JADX WARN: Code duplicated, block: B:37:0x023d  */
    /* JADX WARN: Code duplicated, block: B:40:0x0251  */
    /* JADX WARN: Code duplicated, block: B:41:0x0265  */
    /* JADX WARN: Code duplicated, block: B:44:0x02a7  */
    /* JADX WARN: Code duplicated, block: B:45:0x02ac  */
    /* JADX WARN: Code duplicated, block: B:48:0x02c5  */
    /* JADX WARN: Code duplicated, block: B:51:0x02d4  */
    /* JADX WARN: Code duplicated, block: B:54:0x02ed  */
    /* JADX WARN: Code duplicated, block: B:57:0x02fb  */
    /* JADX WARN: Code duplicated, block: B:60:0x0300  */
    /* JADX WARN: Code duplicated, block: B:61:0x0316  */
    /* JADX WARN: Code duplicated, block: B:63:0x0319  */
    /* JADX WARN: Code duplicated, block: B:64:0x0332  */
    /* JADX WARN: Code duplicated, block: B:67:0x0338  */
    /* JADX WARN: Code duplicated, block: B:68:0x0350  */
    /* JADX WARN: Code duplicated, block: B:71:0x0365  */
    /* JADX WARN: Code duplicated, block: B:72:0x0393  */
    /* JADX WARN: Code duplicated, block: B:75:0x03a1  */
    /* JADX WARN: Code duplicated, block: B:7:0x001a  */
    /* JADX WARN: Code duplicated, block: B:82:0x03e9  */
    /* JADX WARN: Code duplicated, block: B:89:0x04bc A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:90:0x04bd  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:90:0x04bd -> B:91:0x04d9). Please report as a decompilation issue!!! */
    /*  JADX ERROR: JadxOverflowException in pass: RegionMakerVisitor
        jadx.core.utils.exceptions.JadxOverflowException: Regions stack size limit reached
        	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:59)
        	at jadx.core.utils.ErrorsCounter.error(ErrorsCounter.java:31)
        	at jadx.core.dex.attributes.nodes.NotificationAttrNode.addError(NotificationAttrNode.java:19)
        */
    @org.jetbrains.annotations.Nullable
    public static final java.lang.Object invokeMeteorAnimeDebian(@org.jetbrains.annotations.NotNull java.lang.String r40, @org.jetbrains.annotations.NotNull com.lagradost.cloudstream3.TvType r41, @org.jetbrains.annotations.Nullable java.lang.Integer r42, @org.jetbrains.annotations.Nullable java.lang.Integer r43, @org.jetbrains.annotations.NotNull kotlin.jvm.functions.Function1<? super com.lagradost.cloudstream3.utils.ExtractorLink, kotlin.Unit> r44, @org.jetbrains.annotations.NotNull kotlin.coroutines.Continuation<? super kotlin.Unit> r45) {
        /*
            Method dump skipped, instruction units count: 1304
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.phisher98.TorraStreamExtractorKt.invokeMeteorAnimeDebian(java.lang.String, com.lagradost.cloudstream3.TvType, java.lang.Integer, java.lang.Integer, kotlin.jvm.functions.Function1, kotlin.coroutines.Continuation):java.lang.Object");
    }

    public static /* synthetic */ Object invokeMeteorAnimeDebian$default(String str, TvType tvType, Integer num, Integer num2, Function1 function1, Continuation continuation, int i, Object obj) {
        if ((i & 4) != 0) {
            num = null;
        }
        if ((i & 8) != 0) {
            num2 = null;
        }
        return invokeMeteorAnimeDebian(str, tvType, num, num2, function1, continuation);
    }
}
