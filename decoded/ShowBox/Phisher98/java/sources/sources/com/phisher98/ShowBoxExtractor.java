package com.phisher98;

import com.lagradost.cloudstream3.MainActivityKt;
import com.lagradost.cloudstream3.ParCollectionsKt;
import com.lagradost.cloudstream3.utils.ExtractorApiKt;
import com.lagradost.cloudstream3.utils.ExtractorLink;
import com.lagradost.cloudstream3.utils.Qualities;
import com.lagradost.nicehttp.NiceResponse;
import com.lagradost.nicehttp.Requests;
import com.lagradost.nicehttp.ResponseParser;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
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
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.text.MatchResult;
import kotlin.text.Regex;
import kotlin.text.StringsKt;
import okhttp3.Interceptor;
import okhttp3.MediaType;
import okhttp3.RequestBody;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;

/* JADX INFO: compiled from: Extractors.kt */
/* JADX INFO: loaded from: /home/runner/work/NepaliStream-CNC-Repo/NepaliStream-CNC-Repo/decoded/ShowBox/Phisher98/java/classes.dex */
@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0010\n\u0002\u0018\u0002\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003Jp\u0010\u0004\u001a\u00020\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u00072\b\u0010\u000b\u001a\u0004\u0018\u00010\f2\u0012\u0010\r\u001a\u000e\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020\u00050\u000e2\u0012\u0010\u0010\u001a\u000e\u0012\u0004\u0012\u00020\u0011\u0012\u0004\u0012\u00020\u00050\u000eH\u0086@¢\u0006\u0002\u0010\u0012J\\\u0010\u0013\u001a\u00020\u00052\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u00072\b\u0010\u0015\u001a\u0004\u0018\u00010\f2\u0012\u0010\u0010\u001a\u000e\u0012\u0004\u0012\u00020\u0011\u0012\u0004\u0012\u00020\u00050\u000eH\u0086@¢\u0006\u0002\u0010\u0016J\\\u0010\u0017\u001a\u00020\u00052\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u00072\b\u0010\u0015\u001a\u0004\u0018\u00010\f2\u0012\u0010\u0010\u001a\u000e\u0012\u0004\u0012\u00020\u0011\u0012\u0004\u0012\u00020\u00050\u000eH\u0086@¢\u0006\u0002\u0010\u0016JF\u0010\u0018\u001a\u00020\u00052\n\b\u0002\u0010\u0019\u001a\u0004\u0018\u00010\f2\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u00072\u0012\u0010\r\u001a\u000e\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020\u00050\u000eH\u0086@¢\u0006\u0002\u0010\u001aJF\u0010\u001b\u001a\u00020\u00052\n\b\u0002\u0010\u0019\u001a\u0004\u0018\u00010\f2\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u00072\u0012\u0010\r\u001a\u000e\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020\u00050\u000eH\u0086@¢\u0006\u0002\u0010\u001aJ\u0018\u0010\u001c\u001a\u00020\f2\u0006\u0010\u001d\u001a\u00020\f2\u0006\u0010\u001e\u001a\u00020\fH\u0002J\u0012\u0010\u001f\u001a\u00020\u00072\b\u0010 \u001a\u0004\u0018\u00010\fH\u0002J1\u0010!\u001a\u000e\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\f0\"2\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u0007H\u0002¢\u0006\u0002\u0010#¨\u0006$"}, d2 = {"Lcom/phisher98/ShowBoxExtractor;", "Lcom/phisher98/ShowBox;", "<init>", "()V", "invokeInternalSource", "", "id", "", "type", "season", "episode", "superToken", "", "subtitleCallback", "Lkotlin/Function1;", "Lcom/lagradost/cloudstream3/SubtitleFile;", "callback", "Lcom/lagradost/cloudstream3/utils/ExtractorLink;", "(Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/String;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "invokeExternalSource", "mediaId", "uitoken", "(Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/String;Lkotlin/jvm/functions/Function1;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "invokeExternalM3u8Source", "invokeWatchsomuch", "imdbId", "(Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/Integer;Lkotlin/jvm/functions/Function1;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "invokeOpenSubs", "fixUrl", "url", "domain", "getIndexQuality", "str", "getEpisodeSlug", "Lkotlin/Pair;", "(Ljava/lang/Integer;Ljava/lang/Integer;)Lkotlin/Pair;", "ShowBox"}, k = 1, mv = {2, 4, 0}, xi = 48)
@SourceDebugExtension({"SMAP\nExtractors.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Extractors.kt\ncom/phisher98/ShowBoxExtractor\n+ 2 ShowBox.kt\ncom/phisher98/ShowBox\n+ 3 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n+ 4 NiceResponse.kt\ncom/lagradost/nicehttp/NiceResponse\n+ 5 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,402:1\n365#2,12:403\n365#2,12:419\n2068#3,2:415\n296#3,2:417\n2068#3:431\n2198#3,14:432\n2069#3:446\n777#3:468\n873#3,2:469\n777#3:491\n873#3,2:492\n1739#3:504\n1814#3,3:505\n1739#3:513\n1814#3,3:514\n73#4,5:447\n73#4,5:452\n73#4,5:457\n73#4,5:463\n73#4,5:471\n73#4,5:476\n73#4,5:481\n73#4,5:486\n73#4,5:494\n73#4,5:499\n73#4,5:508\n1#5:462\n*S KotlinDebug\n*F\n+ 1 Extractors.kt\ncom/phisher98/ShowBoxExtractor\n*L\n63#1:403,12\n78#1:419,12\n65#1:415,2\n70#1:417,2\n79#1:431\n80#1:432,14\n79#1:446\n135#1:468\n135#1:469,2\n241#1:491\n241#1:492,2\n332#1:504\n332#1:505,3\n356#1:513\n356#1:514,3\n117#1:447,5\n119#1:452,5\n124#1:457,5\n135#1:463,5\n223#1:471,5\n225#1:476,5\n230#1:481,5\n241#1:486,5\n311#1:494,5\n331#1:499,5\n356#1:508,5\n*E\n"})
public final class ShowBoxExtractor extends ShowBox {

    @NotNull
    public static final ShowBoxExtractor INSTANCE = new ShowBoxExtractor();

    /* JADX INFO: renamed from: com.phisher98.ShowBoxExtractor$invokeExternalM3u8Source$1 */
    /* JADX INFO: compiled from: Extractors.kt */
    @Metadata(k = 3, mv = {2, 4, 0}, xi = 48)
    @DebugMetadata(c = "com.phisher98.ShowBoxExtractor", f = "Extractors.kt", i = {0, 0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 1, 1, 1, 1, 1, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4}, l = {222, 224, 229, 237, 246}, m = "invokeExternalM3u8Source", n = {"mediaId", "type", "season", "episode", "uitoken", "callback", "seasonSlug", "episodeSlug", "mediaId", "type", "season", "episode", "uitoken", "callback", "seasonSlug", "episodeSlug", "mediaId", "type", "season", "episode", "uitoken", "callback", "seasonSlug", "episodeSlug", "shareKey", "headers", "mediaId", "type", "season", "episode", "uitoken", "callback", "seasonSlug", "episodeSlug", "shareKey", "headers", "shareRes", "parentId", "mediaId", "type", "season", "episode", "uitoken", "callback", "seasonSlug", "episodeSlug", "shareKey", "headers", "shareRes", "fids"}, nl = {223, 225, 230, 241, 293}, s = {"L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$6", "L$7", "L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$6", "L$7", "L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$6", "L$7", "L$8", "L$9", "L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$6", "L$7", "L$8", "L$9", "L$10", "L$11", "L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$6", "L$7", "L$8", "L$9", "L$10", "L$11"}, v = 2)
    static final class C00091 extends ContinuationImpl {
        Object L$0;
        Object L$1;
        Object L$10;
        Object L$11;
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

        C00091(Continuation<? super C00091> continuation) {
            super(continuation);
        }

        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return ShowBoxExtractor.this.invokeExternalM3u8Source(null, null, null, null, null, null, (Continuation) this);
        }
    }

    /* JADX INFO: renamed from: com.phisher98.ShowBoxExtractor$invokeExternalSource$1 */
    /* JADX INFO: compiled from: Extractors.kt */
    @Metadata(k = 3, mv = {2, 4, 0}, xi = 48)
    @DebugMetadata(c = "com.phisher98.ShowBoxExtractor", f = "Extractors.kt", i = {0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4}, l = {116, 118, 123, 131, 140}, m = "invokeExternalSource", n = {"mediaId", "type", "season", "episode", "uitoken", "callback", "videoheaders", "seasonSlug", "episodeSlug", "mediaId", "type", "season", "episode", "uitoken", "callback", "videoheaders", "seasonSlug", "episodeSlug", "mediaId", "type", "season", "episode", "uitoken", "callback", "videoheaders", "seasonSlug", "episodeSlug", "shareKey", "headers", "mediaId", "type", "season", "episode", "uitoken", "callback", "videoheaders", "seasonSlug", "episodeSlug", "shareKey", "headers", "shareRes", "parentId", "mediaId", "type", "season", "episode", "uitoken", "callback", "videoheaders", "seasonSlug", "episodeSlug", "shareKey", "headers", "shareRes", "fids"}, nl = {117, 119, 124, 135, 210}, s = {"L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$6", "L$7", "L$8", "L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$6", "L$7", "L$8", "L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$6", "L$7", "L$8", "L$9", "L$10", "L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$6", "L$7", "L$8", "L$9", "L$10", "L$11", "L$12", "L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$6", "L$7", "L$8", "L$9", "L$10", "L$11", "L$12"}, v = 2)
    static final class C00111 extends ContinuationImpl {
        Object L$0;
        Object L$1;
        Object L$10;
        Object L$11;
        Object L$12;
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

        C00111(Continuation<? super C00111> continuation) {
            super(continuation);
        }

        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return ShowBoxExtractor.this.invokeExternalSource(null, null, null, null, null, null, (Continuation) this);
        }
    }

    /* JADX INFO: renamed from: com.phisher98.ShowBoxExtractor$invokeInternalSource$1 */
    /* JADX INFO: compiled from: Extractors.kt */
    @Metadata(k = 3, mv = {2, 4, 0}, xi = 48)
    @DebugMetadata(c = "com.phisher98.ShowBoxExtractor", f = "Extractors.kt", i = {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1}, l = {66, 82}, m = "invokeInternalSource", n = {"id", "type", "season", "episode", "superToken", "subtitleCallback", "callback", "videoheaders", "query", "linkData", "$this$forEach$iv", "element$iv", "link", "id", "type", "season", "episode", "superToken", "subtitleCallback", "callback", "videoheaders", "query", "linkData", "fid", "subtitleQuery", "subtitles", "$this$forEach$iv", "element$iv", "subs", "sub"}, nl = {67, 81}, s = {"L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$6", "L$7", "L$8", "L$9", "L$10", "L$12", "L$13", "L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$6", "L$7", "L$8", "L$9", "L$10", "L$11", "L$12", "L$13", "L$15", "L$16", "L$17"}, v = 2)
    static final class C00141 extends ContinuationImpl {
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

        C00141(Continuation<? super C00141> continuation) {
            super(continuation);
        }

        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return ShowBoxExtractor.this.invokeInternalSource(null, null, null, null, null, null, null, (Continuation) this);
        }
    }

    /* JADX INFO: renamed from: com.phisher98.ShowBoxExtractor$invokeOpenSubs$1 */
    /* JADX INFO: compiled from: Extractors.kt */
    @Metadata(k = 3, mv = {2, 4, 0}, xi = 48)
    @DebugMetadata(c = "com.phisher98.ShowBoxExtractor", f = "Extractors.kt", i = {0, 0, 0, 0, 0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1}, l = {355, 358}, m = "invokeOpenSubs", n = {"imdbId", "season", "episode", "subtitleCallback", "slug", "imdbId", "season", "episode", "subtitleCallback", "slug", "$this$map$iv", "$this$mapTo$iv$iv", "destination$iv$iv", "item$iv$iv", "sub"}, nl = {356, 357}, s = {"L$0", "L$1", "L$2", "L$3", "L$4", "L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$6", "L$7", "L$9", "L$10"}, v = 2)
    static final class C00151 extends ContinuationImpl {
        Object L$0;
        Object L$1;
        Object L$10;
        Object L$11;
        Object L$12;
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

        C00151(Continuation<? super C00151> continuation) {
            super(continuation);
        }

        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return ShowBoxExtractor.this.invokeOpenSubs(null, null, null, null, (Continuation) this);
        }
    }

    /* JADX INFO: renamed from: com.phisher98.ShowBoxExtractor$invokeWatchsomuch$1 */
    /* JADX INFO: compiled from: Extractors.kt */
    @Metadata(k = 3, mv = {2, 4, 0}, xi = 48)
    @DebugMetadata(c = "com.phisher98.ShowBoxExtractor", f = "Extractors.kt", i = {0, 0, 0, 0, 0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2}, l = {302, 330, 334}, m = "invokeWatchsomuch", n = {"imdbId", "season", "episode", "subtitleCallback", "id", "imdbId", "season", "episode", "subtitleCallback", "id", "seasonSlug", "episodeSlug", "subUrl", "epsId", "imdbId", "season", "episode", "subtitleCallback", "id", "seasonSlug", "episodeSlug", "subUrl", "$this$map$iv", "$this$mapTo$iv$iv", "destination$iv$iv", "item$iv$iv", "sub", "epsId"}, nl = {311, 331, 333}, s = {"L$0", "L$1", "L$2", "L$3", "L$4", "L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$6", "L$7", "I$0", "L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$6", "L$7", "L$8", "L$9", "L$10", "L$12", "L$13", "I$0"}, v = 2)
    static final class C00161 extends ContinuationImpl {
        int I$0;
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

        C00161(Continuation<? super C00161> continuation) {
            super(continuation);
        }

        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return ShowBoxExtractor.this.invokeWatchsomuch(null, null, null, null, (Continuation) this);
        }
    }

    private ShowBoxExtractor() {
        super(null, 1, null);
    }

    public static /* synthetic */ Object invokeInternalSource$default(ShowBoxExtractor showBoxExtractor, Integer num, Integer num2, Integer num3, Integer num4, String str, Function1 function1, Function1 function2, Continuation continuation, int i, Object obj) {
        if ((i & 1) != 0) {
            num = null;
        }
        if ((i & 2) != 0) {
            num2 = null;
        }
        if ((i & 4) != 0) {
            num3 = null;
        }
        if ((i & 8) != 0) {
            num4 = null;
        }
        return showBoxExtractor.invokeInternalSource(num, num2, num3, num4, str, function1, function2, continuation);
    }

    /* JADX WARN: Code duplicated, block: B:46:0x0345  */
    /* JADX WARN: Code duplicated, block: B:48:0x0389 A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:49:0x038a  */
    /* JADX WARN: Code duplicated, block: B:53:0x03aa  */
    /* JADX WARN: Code duplicated, block: B:7:0x001c  */
    /* JADX WARN: Unreachable blocks removed: 2, instructions: 2 */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:139:0x069d -> B:140:0x06be). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:142:0x06e0 -> B:143:0x06e5). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:49:0x038a -> B:50:0x03a5). Please report as a decompilation issue!!! */
    /*  JADX ERROR: StackOverflowError in pass: RegionMakerVisitor
        java.lang.StackOverflowError
        	at jadx.core.utils.BlockUtils.traverseSuccessorsUntil(BlockUtils.java:731)
        	at jadx.core.utils.BlockUtils.traverseSuccessorsUntil(BlockUtils.java:749)
        */
    @org.jetbrains.annotations.Nullable
    public final java.lang.Object invokeInternalSource(@org.jetbrains.annotations.Nullable java.lang.Integer r37, @org.jetbrains.annotations.Nullable java.lang.Integer r38, @org.jetbrains.annotations.Nullable java.lang.Integer r39, @org.jetbrains.annotations.Nullable java.lang.Integer r40, @org.jetbrains.annotations.Nullable java.lang.String r41, @org.jetbrains.annotations.NotNull kotlin.jvm.functions.Function1<? super com.lagradost.cloudstream3.SubtitleFile, kotlin.Unit> r42, @org.jetbrains.annotations.NotNull kotlin.jvm.functions.Function1<? super com.lagradost.cloudstream3.utils.ExtractorLink, kotlin.Unit> r43, @org.jetbrains.annotations.NotNull kotlin.coroutines.Continuation<? super kotlin.Unit> r44) {
        /*
            Method dump skipped, instruction units count: 1826
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.phisher98.ShowBoxExtractor.invokeInternalSource(java.lang.Integer, java.lang.Integer, java.lang.Integer, java.lang.Integer, java.lang.String, kotlin.jvm.functions.Function1, kotlin.jvm.functions.Function1, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Object invokeInternalSource$toExtractorLink(ShowBox.LinkList $this$invokeInternalSource_u24toExtractorLink, Map<String, String> map, Continuation<? super ExtractorLink> continuation) {
        String quality = $this$invokeInternalSource_u24toExtractorLink.getQuality();
        String path = $this$invokeInternalSource_u24toExtractorLink.getPath();
        if (path == null || StringsKt.isBlank(path)) {
            return null;
        }
        return ExtractorApiKt.newExtractorLink("⌜ ShowBox ⌟ Internal", "⌜ ShowBox ⌟ Internal [" + $this$invokeInternalSource_u24toExtractorLink.getSize() + ']', StringsKt.replace$default($this$invokeInternalSource_u24toExtractorLink.getPath(), "\\/", "", false, 4, (Object) null), ExtractorApiKt.getINFER_TYPE(), new ShowBoxExtractor$invokeInternalSource$toExtractorLink$2(quality, map, null), continuation);
    }

    public static /* synthetic */ Object invokeExternalSource$default(ShowBoxExtractor showBoxExtractor, Integer num, Integer num2, Integer num3, Integer num4, String str, Function1 function1, Continuation continuation, int i, Object obj) {
        if ((i & 1) != 0) {
            num = null;
        }
        if ((i & 2) != 0) {
            num2 = null;
        }
        if ((i & 4) != 0) {
            num3 = null;
        }
        if ((i & 8) != 0) {
            num4 = null;
        }
        return showBoxExtractor.invokeExternalSource(num, num2, num3, num4, str, function1, continuation);
    }

    /* JADX WARN: Code duplicated, block: B:113:0x0666  */
    /* JADX WARN: Code duplicated, block: B:128:0x06d9  */
    /* JADX WARN: Code duplicated, block: B:131:0x06fc  */
    /* JADX WARN: Code duplicated, block: B:133:0x070a  */
    /* JADX WARN: Code duplicated, block: B:135:0x070d  */
    /* JADX WARN: Code duplicated, block: B:137:0x0787 A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:138:0x0788  */
    /* JADX WARN: Code duplicated, block: B:167:0x06dc A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:40:0x03f5 A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:41:0x03f6  */
    /* JADX WARN: Code duplicated, block: B:49:0x0425  */
    /* JADX WARN: Code duplicated, block: B:7:0x001e  */
    /* JADX WARN: Code duplicated, block: B:95:0x061e A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:96:0x061f  */
    @Nullable
    public final Object invokeExternalSource(@Nullable Integer mediaId, @Nullable Integer type, @Nullable Integer season, @Nullable Integer episode, @Nullable String uitoken, @NotNull Function1<? super ExtractorLink, Unit> function1, @NotNull Continuation<? super Unit> continuation) {
        C00111 c00111;
        String str;
        Object obj;
        String str2;
        String str3;
        String str4;
        Object obj2;
        C00111 c00112;
        Integer $result;
        Object obj3;
        Integer type2;
        Integer season2;
        String uitoken2;
        Function1<? super ExtractorLink, Unit> function2;
        Map videoheaders;
        String episodeSlug;
        String seasonSlug;
        Integer episode2;
        Object safe;
        ShowBox.ExternalResponse externalResponse;
        Integer season3;
        Integer season4;
        String uitoken3;
        Function1<? super ExtractorLink, Unit> function3;
        String episodeSlug2;
        String seasonSlug2;
        Map videoheaders2;
        Integer type3;
        Function1<? super ExtractorLink, Unit> function4;
        Integer episode3;
        String uitoken4;
        Map videoheaders3;
        String seasonSlug3;
        ShowBox.ExternalResponse.Data data;
        String shareKey;
        String uitoken5;
        Function1<? super ExtractorLink, Unit> function5;
        String seasonSlug4;
        String seasonSlug5;
        Map videoheaders4;
        Map headers;
        List file_list;
        String str5;
        C00111 c00113;
        String seasonSlug6;
        String uitoken6;
        Function1<? super ExtractorLink, Unit> function6;
        Map videoheaders5;
        String uitoken7;
        String episodeSlug3;
        Integer season5;
        Integer type4;
        Integer season6;
        Object safe2;
        ShowBox.ExternalResponse externalResponse2;
        ShowBox.ExternalResponse.Data data2;
        String shareLink;
        Integer mediaId2;
        Integer type5;
        Object safe3;
        ShowBox.ExternalResponse externalResponse3;
        ShowBox.ExternalResponse.Data shareRes;
        ShowBox.ExternalResponse.Data shareRes2;
        Object fid;
        Object obj4;
        String uitoken8;
        String shareKey2;
        String episodeSlug4;
        Function1<? super ExtractorLink, Unit> function7;
        String seasonSlug7;
        Map videoheaders6;
        String shareKey3;
        Map headers2;
        Function1<? super ExtractorLink, Unit> function8;
        Map videoheaders7;
        String seasonSlug8;
        String episodeSlug5;
        Integer type6;
        Integer season7;
        ShowBox.ExternalResponse.Data shareRes3;
        Object obj5;
        Integer season8;
        Integer episode4;
        Integer type7;
        Integer mediaId3;
        List fids;
        C00122 c00122;
        Integer mediaId4;
        Integer type8;
        Object safe4;
        ShowBox.ExternalResponse externalResponse4;
        ShowBox.ExternalResponse.Data data3;
        Iterable file_list2;
        int $i$f$filter;
        Object obj6;
        Integer season9;
        int $i$f$filter2;
        if (continuation instanceof C00111) {
            c00111 = (C00111) continuation;
            if ((c00111.label & Integer.MIN_VALUE) != 0) {
                c00111.label -= Integer.MIN_VALUE;
            } else {
                c00111 = new C00111(continuation);
            }
        } else {
            c00111 = new C00111(continuation);
        }
        Object $result2 = c00111.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (c00111.label) {
            case 0:
                ResultKt.throwOnFailure($result2);
                Map videoheaders8 = MapsKt.mapOf(new Pair[]{TuplesKt.to("Accept", "*/*"), TuplesKt.to("Accept-Language", "en-US,en;q=0.8"), TuplesKt.to("Connection", "keep-alive"), TuplesKt.to("Range", "bytes=0-"), TuplesKt.to("Referer", getThirdAPI()), TuplesKt.to("Sec-Fetch-Dest", "video"), TuplesKt.to("Sec-Fetch-Mode", "no-cors"), TuplesKt.to("Sec-Fetch-Site", "cross-site"), TuplesKt.to("Sec-Fetch-Storage-Access", "none"), TuplesKt.to("Sec-GPC", "1"), TuplesKt.to("User-Agent", "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/139.0.0.0 Safari/537.36"), TuplesKt.to("sec-ch-ua", "\"Not;A=Brand\";v=\"99\", \"Brave\";v=\"139\", \"Chromium\";v=\"139\""), TuplesKt.to("sec-ch-ua-mobile", "?0"), TuplesKt.to("sec-ch-ua-platform", "\"Windows\"")});
                Pair<String, String> episodeSlug6 = getEpisodeSlug(season, episode);
                String seasonSlug9 = (String) episodeSlug6.component1();
                String episodeSlug7 = (String) episodeSlug6.component2();
                Requests app = MainActivityKt.getApp();
                String str6 = getThirdAPI() + "/mbp/to_share_page?box_type=" + type + "&mid=" + mediaId + "&json=1";
                c00111.L$0 = mediaId;
                c00111.L$1 = type;
                c00111.L$2 = season;
                c00111.L$3 = SpillingKt.nullOutSpilledVariable(episode);
                c00111.L$4 = uitoken;
                c00111.L$5 = function1;
                c00111.L$6 = videoheaders8;
                c00111.L$7 = seasonSlug9;
                c00111.L$8 = episodeSlug7;
                c00111.label = 1;
                C00111 c00114 = c00111;
                str = "&json=1";
                obj = coroutine_suspended;
                str2 = "&mid=";
                str3 = "/mbp/to_share_page?box_type=";
                str4 = "/file/file_share_list?share_key=";
                obj2 = "Accept-Language";
                Object obj7 = Requests.get$default(app, str6, (Map) null, (String) null, (Map) null, (Map) null, false, 0, (TimeUnit) null, 0L, (Interceptor) null, false, (ResponseParser) null, c00114, 4094, (Object) null);
                c00112 = c00114;
                if (obj7 == obj) {
                    return obj;
                }
                $result = mediaId;
                obj3 = obj7;
                type2 = type;
                season2 = season;
                uitoken2 = uitoken;
                function2 = function1;
                videoheaders = videoheaders8;
                episodeSlug = episodeSlug7;
                seasonSlug = seasonSlug9;
                episode2 = episode;
                NiceResponse this_$iv = (NiceResponse) obj3;
                try {
                    ResponseParser parser = this_$iv.getParser();
                    Intrinsics.checkNotNull(parser);
                    try {
                        safe = parser.parseSafe(this_$iv.getText(), Reflection.getOrCreateKotlinClass(ShowBox.ExternalResponse.class));
                    } catch (Exception e) {
                        e$iv = e;
                        e$iv.printStackTrace();
                        safe = null;
                    }
                    break;
                } catch (Exception e2) {
                    e$iv = e2;
                }
                externalResponse = (ShowBox.ExternalResponse) safe;
                if (externalResponse != null || (data = externalResponse.getData()) == null || (shareKey = data.getLink()) == null) {
                    Requests app2 = MainActivityKt.getApp();
                    String str7 = getThirdAPI() + str3 + type2 + str2 + $result + str;
                    c00112.L$0 = SpillingKt.nullOutSpilledVariable($result);
                    c00112.L$1 = SpillingKt.nullOutSpilledVariable(type2);
                    c00112.L$2 = season2;
                    c00112.L$3 = SpillingKt.nullOutSpilledVariable(episode2);
                    c00112.L$4 = uitoken2;
                    c00112.L$5 = function2;
                    c00112.L$6 = videoheaders;
                    c00112.L$7 = seasonSlug;
                    c00112.L$8 = episodeSlug;
                    c00112.label = 2;
                    season3 = type2;
                    season4 = season2;
                    uitoken3 = uitoken2;
                    function3 = function2;
                    episodeSlug2 = episodeSlug;
                    seasonSlug2 = seasonSlug;
                    videoheaders2 = videoheaders;
                    C00111 c00115 = c00112;
                    type3 = $result;
                    $result2 = Requests.get$default(app2, str7, (Map) null, (String) null, (Map) null, (Map) null, false, 0, (TimeUnit) null, 0L, (Interceptor) null, false, (ResponseParser) null, c00115, 4094, (Object) null);
                    c00112 = c00115;
                    if ($result2 == obj) {
                        return obj;
                    }
                    function4 = function3;
                    episode3 = episode2;
                    uitoken4 = uitoken3;
                    videoheaders3 = videoheaders2;
                    seasonSlug3 = seasonSlug2;
                    NiceResponse this_$iv2 = (NiceResponse) $result2;
                    try {
                        ResponseParser parser2 = this_$iv2.getParser();
                        Intrinsics.checkNotNull(parser2);
                        safe2 = parser2.parseSafe(this_$iv2.getText(), Reflection.getOrCreateKotlinClass(ShowBox.ExternalResponse.class));
                    } catch (Exception e$iv) {
                        e$iv.printStackTrace();
                        safe2 = null;
                    }
                    externalResponse2 = (ShowBox.ExternalResponse) safe2;
                    if (externalResponse2 != null || (data2 = externalResponse2.getData()) == null || (shareLink = data2.getShareLink()) == null) {
                        return Unit.INSTANCE;
                    }
                    shareKey = StringsKt.substringAfterLast$default(shareLink, "/", (String) null, 2, (Object) null);
                    function5 = function4;
                    uitoken5 = uitoken4;
                    episode2 = episode3;
                    videoheaders4 = videoheaders3;
                    seasonSlug5 = seasonSlug3;
                    seasonSlug4 = episodeSlug2;
                    break;
                } else {
                    type3 = $result;
                    season3 = type2;
                    season4 = season2;
                    uitoken5 = uitoken2;
                    function5 = function2;
                    seasonSlug4 = episodeSlug;
                    seasonSlug5 = seasonSlug;
                    videoheaders4 = videoheaders;
                }
                Map headers3 = MapsKt.mapOf(TuplesKt.to(obj2, "en"));
                Requests app3 = MainActivityKt.getApp();
                String str8 = str4;
                String str9 = getThirdAPI() + str8 + shareKey;
                c00112.L$0 = SpillingKt.nullOutSpilledVariable(type3);
                c00112.L$1 = SpillingKt.nullOutSpilledVariable(season3);
                c00112.L$2 = season4;
                c00112.L$3 = SpillingKt.nullOutSpilledVariable(episode2);
                c00112.L$4 = uitoken5;
                c00112.L$5 = function5;
                c00112.L$6 = videoheaders4;
                c00112.L$7 = seasonSlug5;
                c00112.L$8 = seasonSlug4;
                c00112.L$9 = shareKey;
                c00112.L$10 = headers3;
                c00112.label = 3;
                String episodeSlug8 = seasonSlug4;
                String seasonSlug10 = seasonSlug5;
                Map videoheaders9 = videoheaders4;
                headers = headers3;
                Function1<? super ExtractorLink, Unit> function9 = function5;
                C00111 c00116 = c00112;
                file_list = null;
                Integer mediaId5 = type3;
                str5 = str8;
                $result2 = Requests.get$default(app3, str9, headers, (String) null, (Map) null, (Map) null, false, 0, (TimeUnit) null, 0L, (Interceptor) null, false, (ResponseParser) null, c00116, 4092, (Object) null);
                c00113 = c00116;
                if ($result2 == obj) {
                    return obj;
                }
                seasonSlug6 = shareKey;
                uitoken6 = uitoken5;
                function6 = function9;
                videoheaders5 = videoheaders9;
                uitoken7 = seasonSlug10;
                episodeSlug3 = episodeSlug8;
                season5 = season4;
                type4 = season3;
                season6 = mediaId5;
                NiceResponse this_$iv3 = (NiceResponse) $result2;
                try {
                    ResponseParser parser3 = this_$iv3.getParser();
                    Intrinsics.checkNotNull(parser3);
                    mediaId2 = season6;
                    try {
                        type5 = type4;
                        try {
                            safe3 = parser3.parseSafe(this_$iv3.getText(), Reflection.getOrCreateKotlinClass(ShowBox.ExternalResponse.class));
                        } catch (Exception e3) {
                            e$iv = e3;
                            e$iv.printStackTrace();
                            safe3 = file_list;
                        }
                    } catch (Exception e4) {
                        e$iv = e4;
                        type5 = type4;
                    }
                    break;
                } catch (Exception e5) {
                    e$iv = e5;
                    mediaId2 = season6;
                    type5 = type4;
                }
                externalResponse3 = (ShowBox.ExternalResponse) safe3;
                if (externalResponse3 != null || (shareRes = externalResponse3.getData()) == null) {
                    return Unit.INSTANCE;
                }
                if (season5 != null) {
                    ArrayList<ShowBox.ExternalResponse.Data.FileList> file_list3 = shareRes.getFile_list();
                    if (file_list3 != null) {
                        Iterator it = file_list3.iterator();
                        while (true) {
                            if (it.hasNext()) {
                                Object next = it.next();
                                ShowBox.ExternalResponse.Data.FileList it2 = (ShowBox.ExternalResponse.Data.FileList) next;
                                shareRes2 = shareRes;
                                Iterator it3 = it;
                                if (StringsKt.equals(it2.getFile_name(), "season " + season5.intValue(), true)) {
                                    obj5 = next;
                                } else {
                                    shareRes = shareRes2;
                                    it = it3;
                                }
                            } else {
                                shareRes2 = shareRes;
                                obj5 = file_list;
                            }
                        }
                        ShowBox.ExternalResponse.Data.FileList fileList = (ShowBox.ExternalResponse.Data.FileList) obj5;
                        if (fileList != null) {
                            fid = fileList.getFid();
                        }
                        obj4 = fid;
                        Requests app4 = MainActivityKt.getApp();
                        String str10 = getThirdAPI() + str5 + seasonSlug6 + "&parent_id=" + obj4 + "&page=1";
                        c00113.L$0 = SpillingKt.nullOutSpilledVariable(mediaId2);
                        c00113.L$1 = SpillingKt.nullOutSpilledVariable(type5);
                        c00113.L$2 = SpillingKt.nullOutSpilledVariable(season5);
                        c00113.L$3 = SpillingKt.nullOutSpilledVariable(episode2);
                        c00113.L$4 = uitoken6;
                        c00113.L$5 = function6;
                        c00113.L$6 = videoheaders5;
                        c00113.L$7 = uitoken7;
                        c00113.L$8 = episodeSlug3;
                        c00113.L$9 = seasonSlug6;
                        c00113.L$10 = SpillingKt.nullOutSpilledVariable(headers);
                        c00113.L$11 = SpillingKt.nullOutSpilledVariable(shareRes2);
                        c00113.L$12 = SpillingKt.nullOutSpilledVariable(obj4);
                        c00113.label = 4;
                        uitoken8 = uitoken6;
                        shareKey2 = seasonSlug6;
                        episodeSlug4 = episodeSlug3;
                        function7 = function6;
                        seasonSlug7 = uitoken7;
                        videoheaders6 = videoheaders5;
                        C00111 c00117 = c00113;
                        $result2 = Requests.get$default(app4, str10, headers, (String) null, (Map) null, (Map) null, false, 0, (TimeUnit) null, 0L, (Interceptor) null, false, (ResponseParser) null, c00117, 4092, (Object) null);
                        c00113 = c00117;
                        if ($result2 == obj) {
                            return obj;
                        }
                        uitoken6 = uitoken8;
                        shareKey3 = shareKey2;
                        headers2 = headers;
                        function8 = function7;
                        videoheaders7 = videoheaders6;
                        seasonSlug8 = seasonSlug7;
                        episodeSlug5 = episodeSlug4;
                        type6 = mediaId2;
                        season7 = type5;
                        shareRes3 = shareRes2;
                        NiceResponse this_$iv4 = (NiceResponse) $result2;
                        try {
                            ResponseParser parser4 = this_$iv4.getParser();
                            Intrinsics.checkNotNull(parser4);
                            mediaId4 = type6;
                            try {
                                type8 = season7;
                                try {
                                    safe4 = parser4.parseSafe(this_$iv4.getText(), Reflection.getOrCreateKotlinClass(ShowBox.ExternalResponse.class));
                                } catch (Exception e6) {
                                    e$iv = e6;
                                    e$iv.printStackTrace();
                                    safe4 = file_list;
                                }
                            } catch (Exception e7) {
                                e$iv = e7;
                                type8 = season7;
                            }
                        } catch (Exception e8) {
                            e$iv = e8;
                            mediaId4 = type6;
                            type8 = season7;
                        }
                        externalResponse4 = (ShowBox.ExternalResponse) safe4;
                        if (externalResponse4 != null || (data3 = externalResponse4.getData()) == null || (file_list2 = data3.getFile_list()) == null) {
                            mediaId3 = mediaId4;
                            type7 = type8;
                            season8 = season5;
                            episode4 = episode2;
                        } else {
                            Iterable $this$filter$iv = file_list2;
                            int $i$f$filter3 = 0;
                            Collection destination$iv$iv = new ArrayList();
                            for (Object element$iv$iv : $this$filter$iv) {
                                Iterable $this$filter$iv2 = $this$filter$iv;
                                ShowBox.ExternalResponse.Data.FileList it4 = (ShowBox.ExternalResponse.Data.FileList) element$iv$iv;
                                String file_name = it4.getFile_name();
                                if (file_name != null) {
                                    $i$f$filter = $i$f$filter3;
                                    obj6 = obj4;
                                    season9 = season5;
                                    $i$f$filter2 = StringsKt.contains(file_name, new StringBuilder().append('s').append(seasonSlug8).append('e').append(episodeSlug5).toString(), true) ? 1 : 0;
                                    if ($i$f$filter2 != 0) {
                                        destination$iv$iv.add(element$iv$iv);
                                    }
                                    $this$filter$iv = $this$filter$iv2;
                                    $i$f$filter3 = $i$f$filter;
                                    obj4 = obj6;
                                    season5 = season9;
                                } else {
                                    $i$f$filter = $i$f$filter3;
                                    obj6 = obj4;
                                    season9 = season5;
                                }
                                if ($i$f$filter2 != 0) {
                                    destination$iv$iv.add(element$iv$iv);
                                }
                                $this$filter$iv = $this$filter$iv2;
                                $i$f$filter3 = $i$f$filter;
                                obj4 = obj6;
                                season5 = season9;
                            }
                            List list = (List) destination$iv$iv;
                            type7 = type8;
                            season8 = season5;
                            file_list = list;
                            episode4 = episode2;
                            mediaId3 = mediaId4;
                        }
                    } else {
                        shareRes2 = shareRes;
                    }
                    fid = file_list;
                    obj4 = fid;
                    Requests app5 = MainActivityKt.getApp();
                    String str11 = getThirdAPI() + str5 + seasonSlug6 + "&parent_id=" + obj4 + "&page=1";
                    c00113.L$0 = SpillingKt.nullOutSpilledVariable(mediaId2);
                    c00113.L$1 = SpillingKt.nullOutSpilledVariable(type5);
                    c00113.L$2 = SpillingKt.nullOutSpilledVariable(season5);
                    c00113.L$3 = SpillingKt.nullOutSpilledVariable(episode2);
                    c00113.L$4 = uitoken6;
                    c00113.L$5 = function6;
                    c00113.L$6 = videoheaders5;
                    c00113.L$7 = uitoken7;
                    c00113.L$8 = episodeSlug3;
                    c00113.L$9 = seasonSlug6;
                    c00113.L$10 = SpillingKt.nullOutSpilledVariable(headers);
                    c00113.L$11 = SpillingKt.nullOutSpilledVariable(shareRes2);
                    c00113.L$12 = SpillingKt.nullOutSpilledVariable(obj4);
                    c00113.label = 4;
                    uitoken8 = uitoken6;
                    shareKey2 = seasonSlug6;
                    episodeSlug4 = episodeSlug3;
                    function7 = function6;
                    seasonSlug7 = uitoken7;
                    videoheaders6 = videoheaders5;
                    C00111 c00118 = c00113;
                    $result2 = Requests.get$default(app5, str11, headers, (String) null, (Map) null, (Map) null, false, 0, (TimeUnit) null, 0L, (Interceptor) null, false, (ResponseParser) null, c00118, 4092, (Object) null);
                    c00113 = c00118;
                    if ($result2 == obj) {
                        return obj;
                    }
                    uitoken6 = uitoken8;
                    shareKey3 = shareKey2;
                    headers2 = headers;
                    function8 = function7;
                    videoheaders7 = videoheaders6;
                    seasonSlug8 = seasonSlug7;
                    episodeSlug5 = episodeSlug4;
                    type6 = mediaId2;
                    season7 = type5;
                    shareRes3 = shareRes2;
                    NiceResponse this_$iv5 = (NiceResponse) $result2;
                    ResponseParser parser5 = this_$iv5.getParser();
                    Intrinsics.checkNotNull(parser5);
                    mediaId4 = type6;
                    type8 = season7;
                    safe4 = parser5.parseSafe(this_$iv5.getText(), Reflection.getOrCreateKotlinClass(ShowBox.ExternalResponse.class));
                    externalResponse4 = (ShowBox.ExternalResponse) safe4;
                    if (externalResponse4 != null) {
                        mediaId3 = mediaId4;
                        type7 = type8;
                        season8 = season5;
                        episode4 = episode2;
                    } else {
                        mediaId3 = mediaId4;
                        type7 = type8;
                        season8 = season5;
                        episode4 = episode2;
                    }
                    break;
                } else {
                    file_list = shareRes.getFile_list();
                    season8 = season5;
                    videoheaders7 = videoheaders5;
                    episode4 = episode2;
                    type7 = type5;
                    seasonSlug8 = uitoken7;
                    function8 = function6;
                    episodeSlug5 = episodeSlug3;
                    shareKey3 = seasonSlug6;
                    headers2 = headers;
                    shareRes3 = shareRes;
                    mediaId3 = mediaId2;
                }
                if (file_list == null) {
                    return Unit.INSTANCE;
                }
                fids = file_list;
                String uitoken9 = uitoken6;
                Function1<? super ExtractorLink, Unit> function10 = function8;
                Map videoheaders10 = videoheaders7;
                c00122 = new C00122(uitoken9, shareKey3, function10, videoheaders10, null);
                c00113.L$0 = SpillingKt.nullOutSpilledVariable(mediaId3);
                c00113.L$1 = SpillingKt.nullOutSpilledVariable(type7);
                c00113.L$2 = SpillingKt.nullOutSpilledVariable(season8);
                c00113.L$3 = SpillingKt.nullOutSpilledVariable(episode4);
                c00113.L$4 = SpillingKt.nullOutSpilledVariable(uitoken9);
                c00113.L$5 = SpillingKt.nullOutSpilledVariable(function10);
                c00113.L$6 = SpillingKt.nullOutSpilledVariable(videoheaders10);
                c00113.L$7 = SpillingKt.nullOutSpilledVariable(seasonSlug8);
                c00113.L$8 = SpillingKt.nullOutSpilledVariable(episodeSlug5);
                c00113.L$9 = SpillingKt.nullOutSpilledVariable(shareKey3);
                c00113.L$10 = SpillingKt.nullOutSpilledVariable(headers2);
                c00113.L$11 = SpillingKt.nullOutSpilledVariable(shareRes3);
                c00113.L$12 = SpillingKt.nullOutSpilledVariable(fids);
                c00113.label = 5;
                if (ParCollectionsKt.amapIndexed(fids, c00122, c00113) == obj) {
                    return obj;
                }
                return Unit.INSTANCE;
            case 1:
                String episodeSlug9 = (String) c00111.L$8;
                String seasonSlug11 = (String) c00111.L$7;
                Map videoheaders11 = (Map) c00111.L$6;
                Function1<? super ExtractorLink, Unit> function11 = (Function1) c00111.L$5;
                String uitoken10 = (String) c00111.L$4;
                Integer episode5 = (Integer) c00111.L$3;
                Integer season10 = (Integer) c00111.L$2;
                Integer type9 = (Integer) c00111.L$1;
                Integer mediaId6 = (Integer) c00111.L$0;
                ResultKt.throwOnFailure($result2);
                obj = coroutine_suspended;
                obj2 = "Accept-Language";
                str4 = "/file/file_share_list?share_key=";
                $result = mediaId6;
                type2 = type9;
                c00112 = c00111;
                obj3 = $result2;
                str = "&json=1";
                str2 = "&mid=";
                function2 = function11;
                uitoken2 = uitoken10;
                videoheaders = videoheaders11;
                seasonSlug = seasonSlug11;
                season2 = season10;
                str3 = "/mbp/to_share_page?box_type=";
                episodeSlug = episodeSlug9;
                episode2 = episode5;
                NiceResponse this_$iv6 = (NiceResponse) obj3;
                ResponseParser parser6 = this_$iv6.getParser();
                Intrinsics.checkNotNull(parser6);
                safe = parser6.parseSafe(this_$iv6.getText(), Reflection.getOrCreateKotlinClass(ShowBox.ExternalResponse.class));
                externalResponse = (ShowBox.ExternalResponse) safe;
                if (externalResponse != null) {
                    break;
                }
                Requests app6 = MainActivityKt.getApp();
                String str12 = getThirdAPI() + str3 + type2 + str2 + $result + str;
                c00112.L$0 = SpillingKt.nullOutSpilledVariable($result);
                c00112.L$1 = SpillingKt.nullOutSpilledVariable(type2);
                c00112.L$2 = season2;
                c00112.L$3 = SpillingKt.nullOutSpilledVariable(episode2);
                c00112.L$4 = uitoken2;
                c00112.L$5 = function2;
                c00112.L$6 = videoheaders;
                c00112.L$7 = seasonSlug;
                c00112.L$8 = episodeSlug;
                c00112.label = 2;
                season3 = type2;
                season4 = season2;
                uitoken3 = uitoken2;
                function3 = function2;
                episodeSlug2 = episodeSlug;
                seasonSlug2 = seasonSlug;
                videoheaders2 = videoheaders;
                C00111 c00119 = c00112;
                type3 = $result;
                $result2 = Requests.get$default(app6, str12, (Map) null, (String) null, (Map) null, (Map) null, false, 0, (TimeUnit) null, 0L, (Interceptor) null, false, (ResponseParser) null, c00119, 4094, (Object) null);
                c00112 = c00119;
                if ($result2 == obj) {
                    return obj;
                }
                function4 = function3;
                episode3 = episode2;
                uitoken4 = uitoken3;
                videoheaders3 = videoheaders2;
                seasonSlug3 = seasonSlug2;
                NiceResponse this_$iv7 = (NiceResponse) $result2;
                ResponseParser parser7 = this_$iv7.getParser();
                Intrinsics.checkNotNull(parser7);
                safe2 = parser7.parseSafe(this_$iv7.getText(), Reflection.getOrCreateKotlinClass(ShowBox.ExternalResponse.class));
                externalResponse2 = (ShowBox.ExternalResponse) safe2;
                if (externalResponse2 != null) {
                    break;
                }
                return Unit.INSTANCE;
            case 2:
                String episodeSlug10 = (String) c00111.L$8;
                seasonSlug3 = (String) c00111.L$7;
                videoheaders3 = (Map) c00111.L$6;
                function4 = (Function1) c00111.L$5;
                uitoken4 = (String) c00111.L$4;
                episode3 = (Integer) c00111.L$3;
                Integer season11 = (Integer) c00111.L$2;
                Integer type10 = (Integer) c00111.L$1;
                Integer mediaId7 = (Integer) c00111.L$0;
                ResultKt.throwOnFailure($result2);
                episodeSlug2 = episodeSlug10;
                obj = coroutine_suspended;
                obj2 = "Accept-Language";
                str4 = "/file/file_share_list?share_key=";
                season4 = season11;
                c00112 = c00111;
                season3 = type10;
                type3 = mediaId7;
                NiceResponse this_$iv8 = (NiceResponse) $result2;
                ResponseParser parser8 = this_$iv8.getParser();
                Intrinsics.checkNotNull(parser8);
                safe2 = parser8.parseSafe(this_$iv8.getText(), Reflection.getOrCreateKotlinClass(ShowBox.ExternalResponse.class));
                externalResponse2 = (ShowBox.ExternalResponse) safe2;
                if (externalResponse2 != null) {
                    break;
                }
                return Unit.INSTANCE;
            case 3:
                Map headers4 = (Map) c00111.L$10;
                String shareKey4 = (String) c00111.L$9;
                String episodeSlug11 = (String) c00111.L$8;
                String seasonSlug12 = (String) c00111.L$7;
                Map videoheaders12 = (Map) c00111.L$6;
                function6 = (Function1) c00111.L$5;
                String uitoken11 = (String) c00111.L$4;
                Integer episode6 = (Integer) c00111.L$3;
                Integer season12 = (Integer) c00111.L$2;
                Integer type11 = (Integer) c00111.L$1;
                Integer mediaId8 = (Integer) c00111.L$0;
                ResultKt.throwOnFailure($result2);
                obj = coroutine_suspended;
                videoheaders5 = videoheaders12;
                episode2 = episode6;
                file_list = null;
                c00113 = c00111;
                episodeSlug3 = episodeSlug11;
                uitoken6 = uitoken11;
                season5 = season12;
                uitoken7 = seasonSlug12;
                season6 = mediaId8;
                seasonSlug6 = shareKey4;
                headers = headers4;
                type4 = type11;
                str5 = "/file/file_share_list?share_key=";
                NiceResponse this_$iv9 = (NiceResponse) $result2;
                ResponseParser parser9 = this_$iv9.getParser();
                Intrinsics.checkNotNull(parser9);
                mediaId2 = season6;
                type5 = type4;
                safe3 = parser9.parseSafe(this_$iv9.getText(), Reflection.getOrCreateKotlinClass(ShowBox.ExternalResponse.class));
                externalResponse3 = (ShowBox.ExternalResponse) safe3;
                if (externalResponse3 != null) {
                }
                return Unit.INSTANCE;
            case 4:
                Long parentId = (Long) c00111.L$12;
                shareRes3 = (ShowBox.ExternalResponse.Data) c00111.L$11;
                headers2 = (Map) c00111.L$10;
                shareKey3 = (String) c00111.L$9;
                episodeSlug5 = (String) c00111.L$8;
                seasonSlug8 = (String) c00111.L$7;
                videoheaders7 = (Map) c00111.L$6;
                function8 = (Function1) c00111.L$5;
                uitoken6 = (String) c00111.L$4;
                Integer episode7 = (Integer) c00111.L$3;
                Integer season13 = (Integer) c00111.L$2;
                Integer type12 = (Integer) c00111.L$1;
                Integer mediaId9 = (Integer) c00111.L$0;
                ResultKt.throwOnFailure($result2);
                episode2 = episode7;
                obj = coroutine_suspended;
                obj4 = parentId;
                file_list = null;
                c00113 = c00111;
                season5 = season13;
                season7 = type12;
                type6 = mediaId9;
                NiceResponse this_$iv10 = (NiceResponse) $result2;
                ResponseParser parser10 = this_$iv10.getParser();
                Intrinsics.checkNotNull(parser10);
                mediaId4 = type6;
                type8 = season7;
                safe4 = parser10.parseSafe(this_$iv10.getText(), Reflection.getOrCreateKotlinClass(ShowBox.ExternalResponse.class));
                externalResponse4 = (ShowBox.ExternalResponse) safe4;
                if (externalResponse4 != null) {
                    mediaId3 = mediaId4;
                    type7 = type8;
                    season8 = season5;
                    episode4 = episode2;
                } else {
                    mediaId3 = mediaId4;
                    type7 = type8;
                    season8 = season5;
                    episode4 = episode2;
                }
                if (file_list == null) {
                    return Unit.INSTANCE;
                }
                fids = file_list;
                String uitoken12 = uitoken6;
                Function1<? super ExtractorLink, Unit> function12 = function8;
                Map videoheaders13 = videoheaders7;
                c00122 = new C00122(uitoken12, shareKey3, function12, videoheaders13, null);
                c00113.L$0 = SpillingKt.nullOutSpilledVariable(mediaId3);
                c00113.L$1 = SpillingKt.nullOutSpilledVariable(type7);
                c00113.L$2 = SpillingKt.nullOutSpilledVariable(season8);
                c00113.L$3 = SpillingKt.nullOutSpilledVariable(episode4);
                c00113.L$4 = SpillingKt.nullOutSpilledVariable(uitoken12);
                c00113.L$5 = SpillingKt.nullOutSpilledVariable(function12);
                c00113.L$6 = SpillingKt.nullOutSpilledVariable(videoheaders13);
                c00113.L$7 = SpillingKt.nullOutSpilledVariable(seasonSlug8);
                c00113.L$8 = SpillingKt.nullOutSpilledVariable(episodeSlug5);
                c00113.L$9 = SpillingKt.nullOutSpilledVariable(shareKey3);
                c00113.L$10 = SpillingKt.nullOutSpilledVariable(headers2);
                c00113.L$11 = SpillingKt.nullOutSpilledVariable(shareRes3);
                c00113.L$12 = SpillingKt.nullOutSpilledVariable(fids);
                c00113.label = 5;
                if (ParCollectionsKt.amapIndexed(fids, c00122, c00113) == obj) {
                    return obj;
                }
                return Unit.INSTANCE;
            case 5:
                ResultKt.throwOnFailure($result2);
                return Unit.INSTANCE;
            default:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    /* JADX INFO: renamed from: com.phisher98.ShowBoxExtractor$invokeExternalSource$2 */
    /* JADX INFO: compiled from: Extractors.kt */
    @Metadata(d1 = {"\u0000\u0012\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\n"}, d2 = {"<anonymous>", "", "index", "", "fileList", "Lcom/phisher98/ShowBox$ExternalResponse$Data$FileList;"}, k = 3, mv = {2, 4, 0}, xi = 48)
    @DebugMetadata(c = "com.phisher98.ShowBoxExtractor$invokeExternalSource$2", f = "Extractors.kt", i = {0, 0, 0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1}, l = {144, 196}, m = "invokeSuspend", n = {"fileList", "superToken", "index", "fileList", "superToken", "player", "json", "htmlContent", "document", "sourcesWithQualities", "sourcesJsonArray", "jsonObject", "$this$forEach$iv", "element$iv", "it", "element$iv", "source", "format", "$this$forEach$iv", "parsedSources", "index"}, nl = {147, 195}, s = {"L$0", "L$1", "I$0", "L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$6", "L$7", "L$8", "L$9", "L$13", "L$14", "L$16", "L$17", "L$18", "L$20", "L$21", "I$0"}, v = 2)
    @SourceDebugExtension({"SMAP\nExtractors.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Extractors.kt\ncom/phisher98/ShowBoxExtractor$invokeExternalSource$2\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n+ 3 fake.kt\nkotlin/jvm/internal/FakeKt\n+ 4 AppUtils.kt\ncom/lagradost/cloudstream3/utils/AppUtils\n+ 5 Extensions.kt\ncom/fasterxml/jackson/module/kotlin/ExtensionsKt\n*L\n1#1,402:1\n2068#2:403\n2069#2:405\n2068#2,2:406\n2068#2:408\n2068#2,2:432\n2069#2:434\n1#3:404\n1#3:412\n93#4,2:409\n63#4:411\n64#4,15:413\n95#4,2:430\n50#5:428\n43#5:429\n*S KotlinDebug\n*F\n+ 1 Extractors.kt\ncom/phisher98/ShowBoxExtractor$invokeExternalSource$2\n*L\n161#1:403\n161#1:405\n178#1:406,2\n188#1:408\n191#1:432,2\n188#1:434\n190#1:412\n190#1:409,2\n190#1:411\n190#1:413,15\n190#1:430,2\n190#1:428\n190#1:429\n*E\n"})
    static final class C00122 extends SuspendLambda implements Function3<Integer, ShowBox.ExternalResponse.Data.FileList, Continuation<? super Unit>, Object> {
        final /* synthetic */ Function1<ExtractorLink, Unit> $callback;
        final /* synthetic */ String $shareKey;
        final /* synthetic */ String $uitoken;
        final /* synthetic */ Map<String, String> $videoheaders;
        /* synthetic */ int I$0;
        /* synthetic */ Object L$0;
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

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C00122(String str, String str2, Function1<? super ExtractorLink, Unit> function1, Map<String, String> map, Continuation<? super C00122> continuation) {
            super(3, continuation);
            this.$uitoken = str;
            this.$shareKey = str2;
            this.$callback = function1;
            this.$videoheaders = map;
        }

        public final Object invoke(int i, ShowBox.ExternalResponse.Data.FileList fileList, Continuation<? super Unit> continuation) {
            C00122 c00122 = new C00122(this.$uitoken, this.$shareKey, this.$callback, this.$videoheaders, continuation);
            c00122.I$0 = i;
            c00122.L$0 = fileList;
            return c00122.invokeSuspend(Unit.INSTANCE);
        }

        public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2, Object obj3) {
            return invoke(((Number) obj).intValue(), (ShowBox.ExternalResponse.Data.FileList) obj2, (Continuation<? super Unit>) obj3);
        }

        /* JADX WARN: Code duplicated, block: B:143:0x044e  */
        /* JADX WARN: Code duplicated, block: B:145:0x0464  */
        /* JADX WARN: Code duplicated, block: B:146:0x0467  */
        /* JADX WARN: Code duplicated, block: B:149:0x047d  */
        /* JADX WARN: Code duplicated, block: B:153:0x048a  */
        /* JADX WARN: Code duplicated, block: B:155:0x04b6  */
        /* JADX WARN: Code duplicated, block: B:15:0x00f0  */
        /* JADX WARN: Code duplicated, block: B:163:0x05aa A[ADDED_TO_REGION, REMOVE] */
        /* JADX WARN: Code duplicated, block: B:166:0x05c6  */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:140:0x042c -> B:141:0x0448). Please report as a decompilation issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:161:0x056f -> B:162:0x058d). Please report as a decompilation issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:164:0x05b4 -> B:165:0x05c0). Please report as a decompilation issue!!! */
        /*  JADX ERROR: JadxOverflowException in pass: RegionMakerVisitor
            jadx.core.utils.exceptions.JadxOverflowException: Regions count limit reached at block B:163:0x05aa
            	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:59)
            	at jadx.core.utils.ErrorsCounter.error(ErrorsCounter.java:31)
            	at jadx.core.dex.attributes.nodes.NotificationAttrNode.addError(NotificationAttrNode.java:19)
            */
        public final java.lang.Object invokeSuspend(java.lang.Object r45) {
            /*
                Method dump skipped, instruction units count: 1576
                To view this dump add '--comments-level debug' option
            */
            throw new UnsupportedOperationException("Method not decompiled: com.phisher98.ShowBoxExtractor.C00122.invokeSuspend(java.lang.Object):java.lang.Object");
        }
    }

    public static /* synthetic */ Object invokeExternalM3u8Source$default(ShowBoxExtractor showBoxExtractor, Integer num, Integer num2, Integer num3, Integer num4, String str, Function1 function1, Continuation continuation, int i, Object obj) {
        if ((i & 1) != 0) {
            num = null;
        }
        if ((i & 2) != 0) {
            num2 = null;
        }
        if ((i & 4) != 0) {
            num3 = null;
        }
        if ((i & 8) != 0) {
            num4 = null;
        }
        return showBoxExtractor.invokeExternalM3u8Source(num, num2, num3, num4, str, function1, continuation);
    }

    /* JADX WARN: Code duplicated, block: B:116:0x05ce  */
    /* JADX WARN: Code duplicated, block: B:118:0x05de  */
    /* JADX WARN: Code duplicated, block: B:120:0x05e1  */
    /* JADX WARN: Code duplicated, block: B:122:0x063a A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:35:0x02e0 A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:36:0x02e1  */
    /* JADX WARN: Code duplicated, block: B:44:0x030e  */
    /* JADX WARN: Code duplicated, block: B:7:0x001e  */
    /* JADX WARN: Code duplicated, block: B:81:0x04ef A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:82:0x04f0  */
    /* JADX WARN: Code duplicated, block: B:99:0x0536  */
    @Nullable
    public final Object invokeExternalM3u8Source(@Nullable Integer mediaId, @Nullable Integer type, @Nullable Integer season, @Nullable Integer episode, @Nullable String uitoken, @NotNull Function1<? super ExtractorLink, Unit> function1, @NotNull Continuation<? super Unit> continuation) {
        C00091 c00091;
        Object obj;
        String str;
        String str2;
        String str3;
        String str4;
        C00091 c00092;
        Integer season2;
        String uitoken2;
        Function1<? super ExtractorLink, Unit> function2;
        String seasonSlug;
        Object obj2;
        String episodeSlug;
        Integer $result;
        Integer episode2;
        Integer mediaId2;
        Object safe;
        ShowBox.ExternalResponse externalResponse;
        Integer season3;
        String uitoken3;
        String seasonSlug2;
        String episodeSlug2;
        Integer type2;
        String uitoken4;
        Integer episode3;
        Function1<? super ExtractorLink, Unit> function3;
        String seasonSlug3;
        ShowBox.ExternalResponse.Data data;
        String shareKey;
        String uitoken5;
        String episodeSlug3;
        Map headers;
        String str5;
        C00091 c00093;
        String shareKey2;
        String uitoken6;
        String seasonSlug4;
        String episodeSlug4;
        Integer season4;
        Integer season5;
        Object safe2;
        ShowBox.ExternalResponse externalResponse2;
        ShowBox.ExternalResponse.Data data2;
        String shareLink;
        Object safe3;
        ShowBox.ExternalResponse externalResponse3;
        ShowBox.ExternalResponse.Data shareRes;
        ShowBox.ExternalResponse.Data shareRes2;
        Integer type3;
        Integer mediaId3;
        Long parentId;
        String shareKey3;
        String episodeSlug5;
        String seasonSlug5;
        String uitoken7;
        String shareKey4;
        String uitoken8;
        Map headers2;
        Integer episode4;
        String seasonSlug6;
        Function1<? super ExtractorLink, Unit> function4;
        String episodeSlug6;
        ShowBox.ExternalResponse.Data shareRes3;
        Integer season6;
        Integer type4;
        Object next;
        List fids;
        Integer type5;
        Integer season7;
        String uitoken9;
        Integer mediaId4;
        C00102 c00102;
        Integer mediaId5;
        Integer type6;
        Object safe4;
        ShowBox.ExternalResponse externalResponse4;
        ShowBox.ExternalResponse.Data data3;
        Iterable file_list;
        int $i$f$filter;
        Long parentId2;
        Integer season8;
        if (continuation instanceof C00091) {
            c00091 = (C00091) continuation;
            if ((c00091.label & Integer.MIN_VALUE) != 0) {
                c00091.label -= Integer.MIN_VALUE;
            } else {
                c00091 = new C00091(continuation);
            }
        } else {
            c00091 = new C00091(continuation);
        }
        Object $result2 = c00091.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (c00091.label) {
            case 0:
                ResultKt.throwOnFailure($result2);
                Pair<String, String> episodeSlug7 = getEpisodeSlug(season, episode);
                String seasonSlug7 = (String) episodeSlug7.component1();
                String episodeSlug8 = (String) episodeSlug7.component2();
                Requests app = MainActivityKt.getApp();
                String str6 = getThirdAPI() + "/mbp/to_share_page?box_type=" + type + "&mid=" + mediaId + "&json=1";
                c00091.L$0 = mediaId;
                c00091.L$1 = type;
                c00091.L$2 = season;
                c00091.L$3 = SpillingKt.nullOutSpilledVariable(episode);
                c00091.L$4 = uitoken;
                c00091.L$5 = SpillingKt.nullOutSpilledVariable(function1);
                c00091.L$6 = seasonSlug7;
                c00091.L$7 = episodeSlug8;
                c00091.label = 1;
                obj = coroutine_suspended;
                str = "/mbp/to_share_page?box_type=";
                str2 = "/file/file_share_list?share_key=";
                str3 = "&mid=";
                C00091 c00094 = c00091;
                str4 = "&json=1";
                Object obj3 = Requests.get$default(app, str6, (Map) null, (String) null, (Map) null, (Map) null, false, 0, (TimeUnit) null, 0L, (Interceptor) null, false, (ResponseParser) null, c00094, 4094, (Object) null);
                c00092 = c00094;
                if (obj3 == obj) {
                    return obj;
                }
                season2 = season;
                uitoken2 = uitoken;
                function2 = function1;
                seasonSlug = seasonSlug7;
                obj2 = obj3;
                episodeSlug = episodeSlug8;
                $result = type;
                episode2 = episode;
                mediaId2 = mediaId;
                NiceResponse this_$iv = (NiceResponse) obj2;
                try {
                    ResponseParser parser = this_$iv.getParser();
                    Intrinsics.checkNotNull(parser);
                    safe = parser.parseSafe(this_$iv.getText(), Reflection.getOrCreateKotlinClass(ShowBox.ExternalResponse.class));
                    break;
                } catch (Exception e$iv) {
                    e$iv.printStackTrace();
                    safe = null;
                }
                externalResponse = (ShowBox.ExternalResponse) safe;
                if (externalResponse != null || (data = externalResponse.getData()) == null || (shareKey = data.getLink()) == null) {
                    Requests app2 = MainActivityKt.getApp();
                    String str7 = getThirdAPI() + str + $result + str3 + mediaId2 + str4;
                    c00092.L$0 = SpillingKt.nullOutSpilledVariable(mediaId2);
                    c00092.L$1 = SpillingKt.nullOutSpilledVariable($result);
                    c00092.L$2 = season2;
                    c00092.L$3 = SpillingKt.nullOutSpilledVariable(episode2);
                    c00092.L$4 = uitoken2;
                    c00092.L$5 = SpillingKt.nullOutSpilledVariable(function2);
                    c00092.L$6 = seasonSlug;
                    c00092.L$7 = episodeSlug;
                    c00092.label = 2;
                    season3 = season2;
                    uitoken3 = uitoken2;
                    seasonSlug2 = seasonSlug;
                    episodeSlug2 = episodeSlug;
                    C00091 c00095 = c00092;
                    type2 = $result;
                    $result2 = Requests.get$default(app2, str7, (Map) null, (String) null, (Map) null, (Map) null, false, 0, (TimeUnit) null, 0L, (Interceptor) null, false, (ResponseParser) null, c00095, 4094, (Object) null);
                    c00092 = c00095;
                    if ($result2 == obj) {
                        return obj;
                    }
                    uitoken4 = uitoken3;
                    episode3 = episode2;
                    function3 = function2;
                    seasonSlug3 = seasonSlug2;
                    NiceResponse this_$iv2 = (NiceResponse) $result2;
                    try {
                        ResponseParser parser2 = this_$iv2.getParser();
                        Intrinsics.checkNotNull(parser2);
                        safe2 = parser2.parseSafe(this_$iv2.getText(), Reflection.getOrCreateKotlinClass(ShowBox.ExternalResponse.class));
                    } catch (Exception e$iv2) {
                        e$iv2.printStackTrace();
                        safe2 = null;
                    }
                    externalResponse2 = (ShowBox.ExternalResponse) safe2;
                    if (externalResponse2 != null || (data2 = externalResponse2.getData()) == null || (shareLink = data2.getShareLink()) == null) {
                        return Unit.INSTANCE;
                    }
                    shareKey = StringsKt.substringAfterLast$default(shareLink, "/", (String) null, 2, (Object) null);
                    function2 = function3;
                    uitoken5 = uitoken4;
                    episode2 = episode3;
                    episodeSlug3 = episodeSlug2;
                    break;
                } else {
                    type2 = $result;
                    season3 = season2;
                    uitoken5 = uitoken2;
                    episodeSlug3 = episodeSlug;
                    seasonSlug3 = seasonSlug;
                }
                Map headers3 = MapsKt.mapOf(TuplesKt.to("Accept-Language", "en"));
                Requests app3 = MainActivityKt.getApp();
                String str8 = getThirdAPI() + str2 + shareKey;
                c00092.L$0 = SpillingKt.nullOutSpilledVariable(mediaId2);
                c00092.L$1 = SpillingKt.nullOutSpilledVariable(type2);
                c00092.L$2 = season3;
                c00092.L$3 = SpillingKt.nullOutSpilledVariable(episode2);
                c00092.L$4 = uitoken5;
                c00092.L$5 = SpillingKt.nullOutSpilledVariable(function2);
                c00092.L$6 = seasonSlug3;
                c00092.L$7 = episodeSlug3;
                c00092.L$8 = shareKey;
                c00092.L$9 = headers3;
                c00092.label = 3;
                String seasonSlug8 = seasonSlug3;
                headers = headers3;
                String episodeSlug9 = episodeSlug3;
                C00091 c00096 = c00092;
                Integer type7 = type2;
                str5 = str2;
                $result2 = Requests.get$default(app3, str8, headers, (String) null, (Map) null, (Map) null, false, 0, (TimeUnit) null, 0L, (Interceptor) null, false, (ResponseParser) null, c00096, 4092, (Object) null);
                c00093 = c00096;
                if ($result2 == obj) {
                    return obj;
                }
                shareKey2 = shareKey;
                uitoken6 = uitoken5;
                seasonSlug4 = seasonSlug8;
                episodeSlug4 = episodeSlug9;
                season4 = season3;
                season5 = type7;
                NiceResponse this_$iv3 = (NiceResponse) $result2;
                try {
                    ResponseParser parser3 = this_$iv3.getParser();
                    Intrinsics.checkNotNull(parser3);
                    safe3 = parser3.parseSafe(this_$iv3.getText(), Reflection.getOrCreateKotlinClass(ShowBox.ExternalResponse.class));
                    break;
                } catch (Exception e$iv3) {
                    e$iv3.printStackTrace();
                    safe3 = null;
                }
                externalResponse3 = (ShowBox.ExternalResponse) safe3;
                if (externalResponse3 != null || (shareRes = externalResponse3.getData()) == null) {
                    return Unit.INSTANCE;
                }
                if (season4 != null) {
                    ArrayList<ShowBox.ExternalResponse.Data.FileList> file_list2 = shareRes.getFile_list();
                    if (file_list2 != null) {
                        Iterator<T> it = file_list2.iterator();
                        while (true) {
                            if (it.hasNext()) {
                                next = it.next();
                                ShowBox.ExternalResponse.Data.FileList it2 = (ShowBox.ExternalResponse.Data.FileList) next;
                                shareRes2 = shareRes;
                                type3 = season5;
                                mediaId3 = mediaId2;
                                if (!StringsKt.equals(it2.getFile_name(), "season " + season4.intValue(), true)) {
                                    shareRes = shareRes2;
                                    season5 = type3;
                                    mediaId2 = mediaId3;
                                }
                            } else {
                                shareRes2 = shareRes;
                                type3 = season5;
                                mediaId3 = mediaId2;
                                next = null;
                            }
                        }
                        ShowBox.ExternalResponse.Data.FileList fileList = (ShowBox.ExternalResponse.Data.FileList) next;
                        Long fid = fileList != null ? fileList.getFid() : null;
                        parentId = fid;
                        Requests app4 = MainActivityKt.getApp();
                        String str9 = getThirdAPI() + str5 + shareKey2 + "&parent_id=" + parentId + "&page=1";
                        c00093.L$0 = SpillingKt.nullOutSpilledVariable(mediaId3);
                        c00093.L$1 = SpillingKt.nullOutSpilledVariable(type3);
                        c00093.L$2 = SpillingKt.nullOutSpilledVariable(season4);
                        c00093.L$3 = SpillingKt.nullOutSpilledVariable(episode2);
                        c00093.L$4 = uitoken6;
                        c00093.L$5 = SpillingKt.nullOutSpilledVariable(function2);
                        c00093.L$6 = seasonSlug4;
                        c00093.L$7 = episodeSlug4;
                        c00093.L$8 = shareKey2;
                        c00093.L$9 = SpillingKt.nullOutSpilledVariable(headers);
                        c00093.L$10 = SpillingKt.nullOutSpilledVariable(shareRes2);
                        c00093.L$11 = SpillingKt.nullOutSpilledVariable(parentId);
                        c00093.label = 4;
                        shareKey3 = shareKey2;
                        episodeSlug5 = episodeSlug4;
                        seasonSlug5 = seasonSlug4;
                        uitoken7 = uitoken6;
                        C00091 c00097 = c00093;
                        $result2 = Requests.get$default(app4, str9, headers, (String) null, (Map) null, (Map) null, false, 0, (TimeUnit) null, 0L, (Interceptor) null, false, (ResponseParser) null, c00097, 4092, (Object) null);
                        c00093 = c00097;
                        if ($result2 == obj) {
                            return obj;
                        }
                        shareKey4 = shareKey3;
                        uitoken8 = uitoken7;
                        headers2 = headers;
                        episode4 = episode2;
                        seasonSlug6 = seasonSlug5;
                        function4 = function2;
                        episodeSlug6 = episodeSlug5;
                        shareRes3 = shareRes2;
                        season6 = type3;
                        type4 = mediaId3;
                        NiceResponse this_$iv4 = (NiceResponse) $result2;
                        try {
                            ResponseParser parser4 = this_$iv4.getParser();
                            Intrinsics.checkNotNull(parser4);
                            mediaId5 = type4;
                            try {
                                type6 = season6;
                                try {
                                    safe4 = parser4.parseSafe(this_$iv4.getText(), Reflection.getOrCreateKotlinClass(ShowBox.ExternalResponse.class));
                                } catch (Exception e) {
                                    e$iv = e;
                                    e$iv.printStackTrace();
                                    safe4 = null;
                                }
                            } catch (Exception e2) {
                                e$iv = e2;
                                type6 = season6;
                            }
                        } catch (Exception e3) {
                            e$iv = e3;
                            mediaId5 = type4;
                            type6 = season6;
                        }
                        externalResponse4 = (ShowBox.ExternalResponse) safe4;
                        if (externalResponse4 != null || (data3 = externalResponse4.getData()) == null || (file_list = data3.getFile_list()) == null) {
                            mediaId4 = mediaId5;
                            type5 = type6;
                            season7 = season4;
                            episode2 = episode4;
                            uitoken9 = uitoken8;
                            fids = null;
                        } else {
                            Iterable $this$filter$iv = file_list;
                            int $i$f$filter2 = 0;
                            Collection destination$iv$iv = new ArrayList();
                            for (Object element$iv$iv : $this$filter$iv) {
                                Iterable $this$filter$iv2 = $this$filter$iv;
                                ShowBox.ExternalResponse.Data.FileList it3 = (ShowBox.ExternalResponse.Data.FileList) element$iv$iv;
                                String file_name = it3.getFile_name();
                                boolean z = false;
                                if (file_name != null) {
                                    $i$f$filter = $i$f$filter2;
                                    parentId2 = parentId;
                                    season8 = season4;
                                    if (StringsKt.contains(file_name, 's' + seasonSlug6 + 'e' + episodeSlug6, true)) {
                                        z = true;
                                    }
                                } else {
                                    $i$f$filter = $i$f$filter2;
                                    parentId2 = parentId;
                                    season8 = season4;
                                }
                                if (z) {
                                    destination$iv$iv.add(element$iv$iv);
                                }
                                $this$filter$iv = $this$filter$iv2;
                                $i$f$filter2 = $i$f$filter;
                                parentId = parentId2;
                                season4 = season8;
                            }
                            List list = (List) destination$iv$iv;
                            type5 = type6;
                            season7 = season4;
                            episode2 = episode4;
                            uitoken9 = uitoken8;
                            fids = list;
                            mediaId4 = mediaId5;
                        }
                    } else {
                        shareRes2 = shareRes;
                        type3 = season5;
                        mediaId3 = mediaId2;
                    }
                    parentId = fid;
                    Requests app5 = MainActivityKt.getApp();
                    String str10 = getThirdAPI() + str5 + shareKey2 + "&parent_id=" + parentId + "&page=1";
                    c00093.L$0 = SpillingKt.nullOutSpilledVariable(mediaId3);
                    c00093.L$1 = SpillingKt.nullOutSpilledVariable(type3);
                    c00093.L$2 = SpillingKt.nullOutSpilledVariable(season4);
                    c00093.L$3 = SpillingKt.nullOutSpilledVariable(episode2);
                    c00093.L$4 = uitoken6;
                    c00093.L$5 = SpillingKt.nullOutSpilledVariable(function2);
                    c00093.L$6 = seasonSlug4;
                    c00093.L$7 = episodeSlug4;
                    c00093.L$8 = shareKey2;
                    c00093.L$9 = SpillingKt.nullOutSpilledVariable(headers);
                    c00093.L$10 = SpillingKt.nullOutSpilledVariable(shareRes2);
                    c00093.L$11 = SpillingKt.nullOutSpilledVariable(parentId);
                    c00093.label = 4;
                    shareKey3 = shareKey2;
                    episodeSlug5 = episodeSlug4;
                    seasonSlug5 = seasonSlug4;
                    uitoken7 = uitoken6;
                    C00091 c00098 = c00093;
                    $result2 = Requests.get$default(app5, str10, headers, (String) null, (Map) null, (Map) null, false, 0, (TimeUnit) null, 0L, (Interceptor) null, false, (ResponseParser) null, c00098, 4092, (Object) null);
                    c00093 = c00098;
                    if ($result2 == obj) {
                        return obj;
                    }
                    shareKey4 = shareKey3;
                    uitoken8 = uitoken7;
                    headers2 = headers;
                    episode4 = episode2;
                    seasonSlug6 = seasonSlug5;
                    function4 = function2;
                    episodeSlug6 = episodeSlug5;
                    shareRes3 = shareRes2;
                    season6 = type3;
                    type4 = mediaId3;
                    NiceResponse this_$iv5 = (NiceResponse) $result2;
                    ResponseParser parser5 = this_$iv5.getParser();
                    Intrinsics.checkNotNull(parser5);
                    mediaId5 = type4;
                    type6 = season6;
                    safe4 = parser5.parseSafe(this_$iv5.getText(), Reflection.getOrCreateKotlinClass(ShowBox.ExternalResponse.class));
                    externalResponse4 = (ShowBox.ExternalResponse) safe4;
                    if (externalResponse4 != null) {
                        mediaId4 = mediaId5;
                        type5 = type6;
                        season7 = season4;
                        episode2 = episode4;
                        uitoken9 = uitoken8;
                        fids = null;
                    } else {
                        mediaId4 = mediaId5;
                        type5 = type6;
                        season7 = season4;
                        episode2 = episode4;
                        uitoken9 = uitoken8;
                        fids = null;
                    }
                    break;
                } else {
                    fids = shareRes.getFile_list();
                    type5 = season5;
                    season7 = season4;
                    uitoken9 = uitoken6;
                    function4 = function2;
                    seasonSlug6 = seasonSlug4;
                    episodeSlug6 = episodeSlug4;
                    shareKey4 = shareKey2;
                    headers2 = headers;
                    shareRes3 = shareRes;
                    mediaId4 = mediaId2;
                }
                if (fids == null) {
                    return Unit.INSTANCE;
                }
                c00102 = new C00102(uitoken9, shareKey4, null);
                c00093.L$0 = SpillingKt.nullOutSpilledVariable(mediaId4);
                c00093.L$1 = SpillingKt.nullOutSpilledVariable(type5);
                c00093.L$2 = SpillingKt.nullOutSpilledVariable(season7);
                c00093.L$3 = SpillingKt.nullOutSpilledVariable(episode2);
                c00093.L$4 = SpillingKt.nullOutSpilledVariable(uitoken9);
                c00093.L$5 = SpillingKt.nullOutSpilledVariable(function4);
                c00093.L$6 = SpillingKt.nullOutSpilledVariable(seasonSlug6);
                c00093.L$7 = SpillingKt.nullOutSpilledVariable(episodeSlug6);
                c00093.L$8 = SpillingKt.nullOutSpilledVariable(shareKey4);
                c00093.L$9 = SpillingKt.nullOutSpilledVariable(headers2);
                c00093.L$10 = SpillingKt.nullOutSpilledVariable(shareRes3);
                c00093.L$11 = SpillingKt.nullOutSpilledVariable(fids);
                c00093.label = 5;
                if (ParCollectionsKt.amapIndexed(fids, c00102, c00093) == obj) {
                    return obj;
                }
                return Unit.INSTANCE;
            case 1:
                String episodeSlug10 = (String) c00091.L$7;
                String seasonSlug9 = (String) c00091.L$6;
                Function1<? super ExtractorLink, Unit> function5 = (Function1) c00091.L$5;
                String uitoken10 = (String) c00091.L$4;
                Integer episode5 = (Integer) c00091.L$3;
                Integer season9 = (Integer) c00091.L$2;
                Integer type8 = (Integer) c00091.L$1;
                Integer mediaId6 = (Integer) c00091.L$0;
                ResultKt.throwOnFailure($result2);
                mediaId2 = mediaId6;
                obj2 = $result2;
                obj = coroutine_suspended;
                str2 = "/file/file_share_list?share_key=";
                episode2 = episode5;
                function2 = function5;
                uitoken2 = uitoken10;
                episodeSlug = episodeSlug10;
                $result = type8;
                c00092 = c00091;
                str4 = "&json=1";
                str3 = "&mid=";
                seasonSlug = seasonSlug9;
                season2 = season9;
                str = "/mbp/to_share_page?box_type=";
                NiceResponse this_$iv6 = (NiceResponse) obj2;
                ResponseParser parser6 = this_$iv6.getParser();
                Intrinsics.checkNotNull(parser6);
                safe = parser6.parseSafe(this_$iv6.getText(), Reflection.getOrCreateKotlinClass(ShowBox.ExternalResponse.class));
                externalResponse = (ShowBox.ExternalResponse) safe;
                if (externalResponse != null) {
                    break;
                }
                Requests app6 = MainActivityKt.getApp();
                String str11 = getThirdAPI() + str + $result + str3 + mediaId2 + str4;
                c00092.L$0 = SpillingKt.nullOutSpilledVariable(mediaId2);
                c00092.L$1 = SpillingKt.nullOutSpilledVariable($result);
                c00092.L$2 = season2;
                c00092.L$3 = SpillingKt.nullOutSpilledVariable(episode2);
                c00092.L$4 = uitoken2;
                c00092.L$5 = SpillingKt.nullOutSpilledVariable(function2);
                c00092.L$6 = seasonSlug;
                c00092.L$7 = episodeSlug;
                c00092.label = 2;
                season3 = season2;
                uitoken3 = uitoken2;
                seasonSlug2 = seasonSlug;
                episodeSlug2 = episodeSlug;
                C00091 c00099 = c00092;
                type2 = $result;
                $result2 = Requests.get$default(app6, str11, (Map) null, (String) null, (Map) null, (Map) null, false, 0, (TimeUnit) null, 0L, (Interceptor) null, false, (ResponseParser) null, c00099, 4094, (Object) null);
                c00092 = c00099;
                if ($result2 == obj) {
                    return obj;
                }
                uitoken4 = uitoken3;
                episode3 = episode2;
                function3 = function2;
                seasonSlug3 = seasonSlug2;
                NiceResponse this_$iv7 = (NiceResponse) $result2;
                ResponseParser parser7 = this_$iv7.getParser();
                Intrinsics.checkNotNull(parser7);
                safe2 = parser7.parseSafe(this_$iv7.getText(), Reflection.getOrCreateKotlinClass(ShowBox.ExternalResponse.class));
                externalResponse2 = (ShowBox.ExternalResponse) safe2;
                if (externalResponse2 != null) {
                    break;
                }
                return Unit.INSTANCE;
            case 2:
                String episodeSlug11 = (String) c00091.L$7;
                seasonSlug3 = (String) c00091.L$6;
                function3 = (Function1) c00091.L$5;
                uitoken4 = (String) c00091.L$4;
                episode3 = (Integer) c00091.L$3;
                season3 = (Integer) c00091.L$2;
                type2 = (Integer) c00091.L$1;
                Integer mediaId7 = (Integer) c00091.L$0;
                ResultKt.throwOnFailure($result2);
                episodeSlug2 = episodeSlug11;
                obj = coroutine_suspended;
                str2 = "/file/file_share_list?share_key=";
                mediaId2 = mediaId7;
                c00092 = c00091;
                NiceResponse this_$iv8 = (NiceResponse) $result2;
                ResponseParser parser8 = this_$iv8.getParser();
                Intrinsics.checkNotNull(parser8);
                safe2 = parser8.parseSafe(this_$iv8.getText(), Reflection.getOrCreateKotlinClass(ShowBox.ExternalResponse.class));
                externalResponse2 = (ShowBox.ExternalResponse) safe2;
                if (externalResponse2 != null) {
                    break;
                }
                return Unit.INSTANCE;
            case 3:
                Map headers4 = (Map) c00091.L$9;
                String shareKey5 = (String) c00091.L$8;
                episodeSlug4 = (String) c00091.L$7;
                seasonSlug4 = (String) c00091.L$6;
                Function1<? super ExtractorLink, Unit> function6 = (Function1) c00091.L$5;
                String uitoken11 = (String) c00091.L$4;
                Integer episode6 = (Integer) c00091.L$3;
                Integer season10 = (Integer) c00091.L$2;
                Integer type9 = (Integer) c00091.L$1;
                Integer mediaId8 = (Integer) c00091.L$0;
                ResultKt.throwOnFailure($result2);
                obj = coroutine_suspended;
                function2 = function6;
                uitoken6 = uitoken11;
                episode2 = episode6;
                c00093 = c00091;
                season4 = season10;
                season5 = type9;
                str5 = "/file/file_share_list?share_key=";
                shareKey2 = shareKey5;
                headers = headers4;
                mediaId2 = mediaId8;
                NiceResponse this_$iv9 = (NiceResponse) $result2;
                ResponseParser parser9 = this_$iv9.getParser();
                Intrinsics.checkNotNull(parser9);
                safe3 = parser9.parseSafe(this_$iv9.getText(), Reflection.getOrCreateKotlinClass(ShowBox.ExternalResponse.class));
                externalResponse3 = (ShowBox.ExternalResponse) safe3;
                if (externalResponse3 != null) {
                }
                return Unit.INSTANCE;
            case 4:
                Long parentId3 = (Long) c00091.L$11;
                shareRes3 = (ShowBox.ExternalResponse.Data) c00091.L$10;
                headers2 = (Map) c00091.L$9;
                shareKey4 = (String) c00091.L$8;
                episodeSlug6 = (String) c00091.L$7;
                seasonSlug6 = (String) c00091.L$6;
                function4 = (Function1) c00091.L$5;
                uitoken8 = (String) c00091.L$4;
                episode4 = (Integer) c00091.L$3;
                Integer season11 = (Integer) c00091.L$2;
                Integer type10 = (Integer) c00091.L$1;
                Integer mediaId9 = (Integer) c00091.L$0;
                ResultKt.throwOnFailure($result2);
                obj = coroutine_suspended;
                parentId = parentId3;
                c00093 = c00091;
                season4 = season11;
                season6 = type10;
                type4 = mediaId9;
                NiceResponse this_$iv10 = (NiceResponse) $result2;
                ResponseParser parser10 = this_$iv10.getParser();
                Intrinsics.checkNotNull(parser10);
                mediaId5 = type4;
                type6 = season6;
                safe4 = parser10.parseSafe(this_$iv10.getText(), Reflection.getOrCreateKotlinClass(ShowBox.ExternalResponse.class));
                externalResponse4 = (ShowBox.ExternalResponse) safe4;
                if (externalResponse4 != null) {
                    mediaId4 = mediaId5;
                    type5 = type6;
                    season7 = season4;
                    episode2 = episode4;
                    uitoken9 = uitoken8;
                    fids = null;
                } else {
                    mediaId4 = mediaId5;
                    type5 = type6;
                    season7 = season4;
                    episode2 = episode4;
                    uitoken9 = uitoken8;
                    fids = null;
                }
                if (fids == null) {
                    return Unit.INSTANCE;
                }
                c00102 = new C00102(uitoken9, shareKey4, null);
                c00093.L$0 = SpillingKt.nullOutSpilledVariable(mediaId4);
                c00093.L$1 = SpillingKt.nullOutSpilledVariable(type5);
                c00093.L$2 = SpillingKt.nullOutSpilledVariable(season7);
                c00093.L$3 = SpillingKt.nullOutSpilledVariable(episode2);
                c00093.L$4 = SpillingKt.nullOutSpilledVariable(uitoken9);
                c00093.L$5 = SpillingKt.nullOutSpilledVariable(function4);
                c00093.L$6 = SpillingKt.nullOutSpilledVariable(seasonSlug6);
                c00093.L$7 = SpillingKt.nullOutSpilledVariable(episodeSlug6);
                c00093.L$8 = SpillingKt.nullOutSpilledVariable(shareKey4);
                c00093.L$9 = SpillingKt.nullOutSpilledVariable(headers2);
                c00093.L$10 = SpillingKt.nullOutSpilledVariable(shareRes3);
                c00093.L$11 = SpillingKt.nullOutSpilledVariable(fids);
                c00093.label = 5;
                if (ParCollectionsKt.amapIndexed(fids, c00102, c00093) == obj) {
                    return obj;
                }
                return Unit.INSTANCE;
            case 5:
                ResultKt.throwOnFailure($result2);
                return Unit.INSTANCE;
            default:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    /* JADX INFO: renamed from: com.phisher98.ShowBoxExtractor$invokeExternalM3u8Source$2 */
    /* JADX INFO: compiled from: Extractors.kt */
    @Metadata(d1 = {"\u0000\u0012\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\n"}, d2 = {"<anonymous>", "", "<unused var>", "", "fileList", "Lcom/phisher98/ShowBox$ExternalResponse$Data$FileList;"}, k = 3, mv = {2, 4, 0}, xi = 48)
    @DebugMetadata(c = "com.phisher98.ShowBoxExtractor$invokeExternalM3u8Source$2", f = "Extractors.kt", i = {0, 0, 0, 0}, l = {252}, m = "invokeSuspend", n = {"fileList", "superToken", "mediaType", "body"}, nl = {259}, s = {"L$0", "L$1", "L$2", "L$3"}, v = 2)
    @SourceDebugExtension({"SMAP\nExtractors.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Extractors.kt\ncom/phisher98/ShowBoxExtractor$invokeExternalM3u8Source$2\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,402:1\n1739#2:403\n1814#2,3:404\n296#2,2:407\n*S KotlinDebug\n*F\n+ 1 Extractors.kt\ncom/phisher98/ShowBoxExtractor$invokeExternalM3u8Source$2\n*L\n264#1:403\n264#1:404,3\n265#1:407,2\n*E\n"})
    static final class C00102 extends SuspendLambda implements Function3<Integer, ShowBox.ExternalResponse.Data.FileList, Continuation<? super Unit>, Object> {
        final /* synthetic */ String $shareKey;
        final /* synthetic */ String $uitoken;
        /* synthetic */ Object L$0;
        Object L$1;
        Object L$2;
        Object L$3;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C00102(String str, String str2, Continuation<? super C00102> continuation) {
            super(3, continuation);
            this.$uitoken = str;
            this.$shareKey = str2;
        }

        public final Object invoke(int i, ShowBox.ExternalResponse.Data.FileList fileList, Continuation<? super Unit> continuation) {
            C00102 c00102 = new C00102(this.$uitoken, this.$shareKey, continuation);
            c00102.L$0 = fileList;
            return c00102.invokeSuspend(Unit.INSTANCE);
        }

        public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2, Object obj3) {
            return invoke(((Number) obj).intValue(), (ShowBox.ExternalResponse.Data.FileList) obj2, (Continuation<? super Unit>) obj3);
        }

        /* JADX WARN: Code duplicated, block: B:14:0x0055  */
        public final Object invokeSuspend(Object $result) throws JSONException {
            Object objPost$default;
            Object element$iv;
            List groupValues;
            String sourcesJson;
            ShowBox.ExternalResponse.Data.FileList fileList = (ShowBox.ExternalResponse.Data.FileList) this.L$0;
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            switch (this.label) {
                case 0:
                    ResultKt.throwOnFailure($result);
                    String it = this.$uitoken;
                    if (it == null) {
                        it = "";
                    } else {
                        if (!StringsKt.startsWith$default(it, "ui=", false, 2, (Object) null)) {
                            it = "ui=" + it;
                        }
                        if (it == null) {
                            it = "";
                        }
                    }
                    String superToken = it;
                    MediaType mediaType = MediaType.Companion.get("application/x-www-form-urlencoded; charset=UTF-8");
                    RequestBody body = RequestBody.Companion.create(StringsKt.trimIndent("fid=" + fileList.getFid() + "&share_key=" + this.$shareKey), mediaType);
                    Requests app = MainActivityKt.getApp();
                    String str = ShowBoxExtractor.INSTANCE.getThirdAPI() + "/file/player";
                    Pair[] pairArr = {TuplesKt.to("Cookie", superToken), TuplesKt.to("content-type", "application/x-www-form-urlencoded; charset=UTF-8")};
                    this.L$0 = SpillingKt.nullOutSpilledVariable(fileList);
                    this.L$1 = SpillingKt.nullOutSpilledVariable(superToken);
                    this.L$2 = SpillingKt.nullOutSpilledVariable(mediaType);
                    this.L$3 = SpillingKt.nullOutSpilledVariable(body);
                    this.label = 1;
                    objPost$default = Requests.post$default(app, str, MapsKt.mapOf(pairArr), (String) null, (Map) null, (Map) null, (Map) null, (List) null, (Object) null, body, false, 0, (TimeUnit) null, 0L, (Interceptor) null, false, (ResponseParser) null, (Continuation) this, 65276, (Object) null);
                    if (objPost$default == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    break;
                    break;
                case 1:
                    ResultKt.throwOnFailure($result);
                    objPost$default = $result;
                    break;
                default:
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            String player = ((NiceResponse) objPost$default).getText();
            Document document = Jsoup.parse(player);
            Iterable $this$map$iv = document.select("script");
            Collection destination$iv$iv = new ArrayList(CollectionsKt.collectionSizeOrDefault($this$map$iv, 10));
            for (Object item$iv$iv : $this$map$iv) {
                destination$iv$iv.add(((Element) item$iv$iv).data());
            }
            Iterable $this$firstOrNull$iv = (List) destination$iv$iv;
            Iterator it2 = $this$firstOrNull$iv.iterator();
            while (true) {
                if (it2.hasNext()) {
                    element$iv = it2.next();
                    ShowBox.ExternalResponse.Data.FileList fileList2 = fileList;
                    if (!StringsKt.contains$default((String) element$iv, "var sources", false, 2, (Object) null)) {
                        fileList = fileList2;
                    }
                } else {
                    element$iv = null;
                }
            }
            String scriptText = (String) element$iv;
            if (scriptText == null) {
                return Unit.INSTANCE;
            }
            MatchResult matchResultFind$default = Regex.find$default(new Regex("var\\s+sources\\s*=\\s*(\\[[\\s\\S]*?]);"), scriptText, 0, 2, (Object) null);
            if (matchResultFind$default == null || (groupValues = matchResultFind$default.getGroupValues()) == null || (sourcesJson = (String) groupValues.get(1)) == null) {
                return Unit.INSTANCE;
            }
            List urls = new ArrayList();
            JSONArray jsonArray = new JSONArray(sourcesJson);
            int length = jsonArray.length();
            for (int i = 0; i < length; i++) {
                JSONObject obj = jsonArray.getJSONObject(i);
                String fileUrl = obj.optString("file");
                if (fileUrl.length() > 0) {
                    urls.add(fileUrl);
                }
            }
            return Unit.INSTANCE;
        }
    }

    public static /* synthetic */ Object invokeWatchsomuch$default(ShowBoxExtractor showBoxExtractor, String str, Integer num, Integer num2, Function1 function1, Continuation continuation, int i, Object obj) {
        if ((i & 1) != 0) {
            str = null;
        }
        if ((i & 2) != 0) {
            num = null;
        }
        if ((i & 4) != 0) {
            num2 = null;
        }
        return showBoxExtractor.invokeWatchsomuch(str, num, num2, function1, continuation);
    }

    /* JADX WARN: Code duplicated, block: B:51:0x0279  */
    /* JADX WARN: Code duplicated, block: B:57:0x0283  */
    /* JADX WARN: Code duplicated, block: B:58:0x0288  */
    /* JADX WARN: Code duplicated, block: B:7:0x001a  */
    /* JADX WARN: Code duplicated, block: B:81:0x03dc  */
    /* JADX WARN: Code duplicated, block: B:83:0x03ee  */
    /* JADX WARN: Code duplicated, block: B:86:0x03fb  */
    /* JADX WARN: Code duplicated, block: B:87:0x040d  */
    /* JADX WARN: Code duplicated, block: B:89:0x0480 A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:90:0x0481  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:86:0x03fb -> B:92:0x04ac). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:90:0x0481 -> B:91:0x0498). Please report as a decompilation issue!!! */
    /*  JADX ERROR: StackOverflowError in pass: RegionMakerVisitor
        java.lang.StackOverflowError
        	at jadx.core.utils.BlockUtils.traverseSuccessorsUntil(BlockUtils.java:731)
        	at jadx.core.utils.BlockUtils.traverseSuccessorsUntil(BlockUtils.java:749)
        */
    @org.jetbrains.annotations.Nullable
    public final java.lang.Object invokeWatchsomuch(@org.jetbrains.annotations.Nullable java.lang.String r33, @org.jetbrains.annotations.Nullable java.lang.Integer r34, @org.jetbrains.annotations.Nullable java.lang.Integer r35, @org.jetbrains.annotations.NotNull kotlin.jvm.functions.Function1<? super com.lagradost.cloudstream3.SubtitleFile, kotlin.Unit> r36, @org.jetbrains.annotations.NotNull kotlin.coroutines.Continuation<? super kotlin.Unit> r37) {
        /*
            Method dump skipped, instruction units count: 1280
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.phisher98.ShowBoxExtractor.invokeWatchsomuch(java.lang.String, java.lang.Integer, java.lang.Integer, kotlin.jvm.functions.Function1, kotlin.coroutines.Continuation):java.lang.Object");
    }

    public static /* synthetic */ Object invokeOpenSubs$default(ShowBoxExtractor showBoxExtractor, String str, Integer num, Integer num2, Function1 function1, Continuation continuation, int i, Object obj) {
        if ((i & 1) != 0) {
            str = null;
        }
        if ((i & 2) != 0) {
            num = null;
        }
        if ((i & 4) != 0) {
            num2 = null;
        }
        return showBoxExtractor.invokeOpenSubs(str, num, num2, function1, continuation);
    }

    /* JADX WARN: Code duplicated, block: B:34:0x01d0  */
    /* JADX WARN: Code duplicated, block: B:36:0x01e4  */
    /* JADX WARN: Code duplicated, block: B:39:0x01ec  */
    /* JADX WARN: Code duplicated, block: B:42:0x01f3 A[PHI: r13
      0x01f3: PHI (r13v5 java.lang.String) = (r13v4 java.lang.String), (r13v8 java.lang.String) binds: [B:38:0x01ea, B:40:0x01f0] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Code duplicated, block: B:47:0x024b A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:48:0x024c  */
    /* JADX WARN: Code duplicated, block: B:7:0x001a  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:48:0x024c -> B:49:0x0264). Please report as a decompilation issue!!! */
    /*  JADX ERROR: StackOverflowError in pass: RegionMakerVisitor
        java.lang.StackOverflowError
        	at jadx.core.utils.BlockUtils.traverseSuccessorsUntil(BlockUtils.java:731)
        	at jadx.core.utils.BlockUtils.traverseSuccessorsUntil(BlockUtils.java:749)
        */
    @org.jetbrains.annotations.Nullable
    public final java.lang.Object invokeOpenSubs(@org.jetbrains.annotations.Nullable java.lang.String r26, @org.jetbrains.annotations.Nullable java.lang.Integer r27, @org.jetbrains.annotations.Nullable java.lang.Integer r28, @org.jetbrains.annotations.NotNull kotlin.jvm.functions.Function1<? super com.lagradost.cloudstream3.SubtitleFile, kotlin.Unit> r29, @org.jetbrains.annotations.NotNull kotlin.coroutines.Continuation<? super kotlin.Unit> r30) {
        /*
            Method dump skipped, instruction units count: 674
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.phisher98.ShowBoxExtractor.invokeOpenSubs(java.lang.String, java.lang.Integer, java.lang.Integer, kotlin.jvm.functions.Function1, kotlin.coroutines.Continuation):java.lang.Object");
    }

    private final String fixUrl(String url, String domain) {
        if (StringsKt.startsWith$default(url, "http", false, 2, (Object) null)) {
            return url;
        }
        if (url.length() == 0) {
            return "";
        }
        boolean startsWithNoHttp = StringsKt.startsWith$default(url, "//", false, 2, (Object) null);
        if (startsWithNoHttp) {
            return "https:" + url;
        }
        if (StringsKt.startsWith$default(url, '/', false, 2, (Object) null)) {
            return domain + url;
        }
        return domain + '/' + url;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final int getIndexQuality(String str) {
        List groupValues;
        String str2;
        Integer intOrNull;
        MatchResult matchResultFind$default = Regex.find$default(new Regex("(\\d{3,4})[pP]"), str == null ? "" : str, 0, 2, (Object) null);
        return (matchResultFind$default == null || (groupValues = matchResultFind$default.getGroupValues()) == null || (str2 = (String) CollectionsKt.getOrNull(groupValues, 1)) == null || (intOrNull = StringsKt.toIntOrNull(str2)) == null) ? Qualities.Unknown.getValue() : intOrNull.intValue();
    }

    static /* synthetic */ Pair getEpisodeSlug$default(ShowBoxExtractor showBoxExtractor, Integer num, Integer num2, int i, Object obj) {
        if ((i & 1) != 0) {
            num = null;
        }
        if ((i & 2) != 0) {
            num2 = null;
        }
        return showBoxExtractor.getEpisodeSlug(num, num2);
    }

    private final Pair<String, String> getEpisodeSlug(Integer season, Integer episode) {
        if (season == null && episode == null) {
            return TuplesKt.to("", "");
        }
        Intrinsics.checkNotNull(season);
        String string = season.intValue() < 10 ? new StringBuilder().append('0').append(season.intValue()).toString() : String.valueOf(season.intValue());
        Intrinsics.checkNotNull(episode);
        return TuplesKt.to(string, episode.intValue() < 10 ? new StringBuilder().append('0').append(episode.intValue()).toString() : String.valueOf(episode.intValue()));
    }
}
