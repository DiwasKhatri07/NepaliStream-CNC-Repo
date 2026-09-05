package com.phisher98;

import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: SubsExtractors.kt */
/* JADX INFO: loaded from: /home/runner/work/NepaliStream-CNC-Repo/NepaliStream-CNC-Repo/decoded/StremioX/Phisher98/java/classes.dex */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\n\bÆ\u0002\u0018\u00002\u00020\u0001:\u0007\u0010\u0011\u0012\u0013\u0014\u0015\u0016B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003JF\u0010\u0004\u001a\u00020\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\t2\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\t2\u0012\u0010\u000b\u001a\u000e\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\u00050\fH\u0086@¢\u0006\u0002\u0010\u000eJF\u0010\u000f\u001a\u00020\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\t2\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\t2\u0012\u0010\u000b\u001a\u000e\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\u00050\fH\u0086@¢\u0006\u0002\u0010\u000e¨\u0006\u0017"}, d2 = {"Lcom/phisher98/SubsExtractors;", "", "<init>", "()V", "invokeOpenSubs", "", "imdbId", "", "season", "", "episode", "subtitleCallback", "Lkotlin/Function1;", "Lcom/lagradost/cloudstream3/SubtitleFile;", "(Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/Integer;Lkotlin/jvm/functions/Function1;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "invokeWatchsomuch", "OsSubtitles", "OsResult", "WatchsomuchTorrents", "WatchsomuchMovies", "WatchsomuchResponses", "WatchsomuchSubtitles", "WatchsomuchSubResponses", "StremioX"}, k = 1, mv = {2, 4, 0}, xi = 48)
@SourceDebugExtension({"SMAP\nSubsExtractors.kt\nKotlin\n*S Kotlin\n*F\n+ 1 SubsExtractors.kt\ncom/phisher98/SubsExtractors\n+ 2 NiceResponse.kt\ncom/lagradost/nicehttp/NiceResponse\n+ 3 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n+ 4 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,117:1\n73#2,5:118\n73#2,5:127\n73#2,5:133\n1739#3:123\n1814#3,3:124\n1739#3:138\n1814#3,3:139\n1#4:132\n*S KotlinDebug\n*F\n+ 1 SubsExtractors.kt\ncom/phisher98/SubsExtractors\n*L\n28#1:118,5\n57#1:127,5\n73#1:133,5\n28#1:123\n28#1:124,3\n73#1:138\n73#1:139,3\n*E\n"})
public final class SubsExtractors {

    @NotNull
    public static final SubsExtractors INSTANCE = new SubsExtractors();

    /* JADX INFO: renamed from: com.phisher98.SubsExtractors$invokeOpenSubs$1 */
    /* JADX INFO: compiled from: SubsExtractors.kt */
    @Metadata(k = 3, mv = {2, 4, 0}, xi = 48)
    @DebugMetadata(c = "com.phisher98.SubsExtractors", f = "SubsExtractors.kt", i = {0, 0, 0, 0, 0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1}, l = {28, 30}, m = "invokeOpenSubs", n = {"imdbId", "season", "episode", "subtitleCallback", "slug", "imdbId", "season", "episode", "subtitleCallback", "slug", "$this$map$iv", "$this$mapTo$iv$iv", "destination$iv$iv", "item$iv$iv", "sub"}, nl = {118, 29}, s = {"L$0", "L$1", "L$2", "L$3", "L$4", "L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$6", "L$7", "L$9", "L$10"}, v = 2)
    static final class C00311 extends ContinuationImpl {
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

        C00311(Continuation<? super C00311> continuation) {
            super(continuation);
        }

        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return SubsExtractors.this.invokeOpenSubs(null, null, null, null, (Continuation) this);
        }
    }

    /* JADX INFO: renamed from: com.phisher98.SubsExtractors$invokeWatchsomuch$1 */
    /* JADX INFO: compiled from: SubsExtractors.kt */
    @Metadata(k = 3, mv = {2, 4, 0}, xi = 48)
    @DebugMetadata(c = "com.phisher98.SubsExtractors", f = "SubsExtractors.kt", i = {0, 0, 0, 0, 0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2}, l = {49, 73, 75}, m = "invokeWatchsomuch", n = {"imdbId", "season", "episode", "subtitleCallback", "id", "imdbId", "season", "episode", "subtitleCallback", "id", "seasonSlug", "episodeSlug", "subUrl", "epsId", "imdbId", "season", "episode", "subtitleCallback", "id", "seasonSlug", "episodeSlug", "subUrl", "$this$map$iv", "$this$mapTo$iv$iv", "destination$iv$iv", "item$iv$iv", "sub", "epsId"}, nl = {57, 124, 74}, s = {"L$0", "L$1", "L$2", "L$3", "L$4", "L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$6", "L$7", "I$0", "L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$6", "L$7", "L$8", "L$9", "L$10", "L$12", "L$13", "I$0"}, v = 2)
    static final class C00321 extends ContinuationImpl {
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

        C00321(Continuation<? super C00321> continuation) {
            super(continuation);
        }

        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return SubsExtractors.this.invokeWatchsomuch(null, null, null, null, (Continuation) this);
        }
    }

    private SubsExtractors() {
    }

    public static /* synthetic */ Object invokeOpenSubs$default(SubsExtractors subsExtractors, String str, Integer num, Integer num2, Function1 function1, Continuation continuation, int i, Object obj) {
        if ((i & 1) != 0) {
            str = null;
        }
        if ((i & 2) != 0) {
            num = null;
        }
        if ((i & 4) != 0) {
            num2 = null;
        }
        return subsExtractors.invokeOpenSubs(str, num, num2, function1, continuation);
    }

    /* JADX WARN: Code duplicated, block: B:43:0x01d8  */
    /* JADX WARN: Code duplicated, block: B:45:0x01ec  */
    /* JADX WARN: Code duplicated, block: B:48:0x01f4  */
    /* JADX WARN: Code duplicated, block: B:51:0x01fb A[PHI: r13
      0x01fb: PHI (r13v5 java.lang.String) = (r13v4 java.lang.String), (r13v8 java.lang.String) binds: [B:47:0x01f2, B:49:0x01f8] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Code duplicated, block: B:56:0x0253 A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:57:0x0254  */
    /* JADX WARN: Code duplicated, block: B:7:0x001a  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:57:0x0254 -> B:58:0x026c). Please report as a decompilation issue!!! */
    /*  JADX ERROR: StackOverflowError in pass: RegionMakerVisitor
        java.lang.StackOverflowError
        	at jadx.core.utils.BlockUtils.traverseSuccessorsUntil(BlockUtils.java:731)
        	at jadx.core.utils.BlockUtils.traverseSuccessorsUntil(BlockUtils.java:749)
        */
    @org.jetbrains.annotations.Nullable
    public final java.lang.Object invokeOpenSubs(@org.jetbrains.annotations.Nullable java.lang.String r26, @org.jetbrains.annotations.Nullable java.lang.Integer r27, @org.jetbrains.annotations.Nullable java.lang.Integer r28, @org.jetbrains.annotations.NotNull kotlin.jvm.functions.Function1<? super com.lagradost.cloudstream3.SubtitleFile, kotlin.Unit> r29, @org.jetbrains.annotations.NotNull kotlin.coroutines.Continuation<? super kotlin.Unit> r30) {
        /*
            Method dump skipped, instruction units count: 682
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.phisher98.SubsExtractors.invokeOpenSubs(java.lang.String, java.lang.Integer, java.lang.Integer, kotlin.jvm.functions.Function1, kotlin.coroutines.Continuation):java.lang.Object");
    }

    public static /* synthetic */ Object invokeWatchsomuch$default(SubsExtractors subsExtractors, String str, Integer num, Integer num2, Function1 function1, Continuation continuation, int i, Object obj) {
        if ((i & 1) != 0) {
            str = null;
        }
        if ((i & 2) != 0) {
            num = null;
        }
        if ((i & 4) != 0) {
            num2 = null;
        }
        return subsExtractors.invokeWatchsomuch(str, num, num2, function1, continuation);
    }

    /* JADX WARN: Code duplicated, block: B:57:0x0280  */
    /* JADX WARN: Code duplicated, block: B:63:0x028a  */
    /* JADX WARN: Code duplicated, block: B:64:0x028f  */
    /* JADX WARN: Code duplicated, block: B:7:0x001a  */
    /* JADX WARN: Code duplicated, block: B:87:0x03cd  */
    /* JADX WARN: Code duplicated, block: B:89:0x03df  */
    /* JADX WARN: Code duplicated, block: B:92:0x03e9  */
    /* JADX WARN: Code duplicated, block: B:93:0x03fe  */
    /* JADX WARN: Code duplicated, block: B:95:0x0470 A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:96:0x0471  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:92:0x03e9 -> B:98:0x04a9). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:96:0x0471 -> B:97:0x048d). Please report as a decompilation issue!!! */
    /*  JADX ERROR: StackOverflowError in pass: RegionMakerVisitor
        java.lang.StackOverflowError
        	at jadx.core.utils.BlockUtils.traverseSuccessorsUntil(BlockUtils.java:731)
        	at jadx.core.utils.BlockUtils.traverseSuccessorsUntil(BlockUtils.java:749)
        */
    @org.jetbrains.annotations.Nullable
    public final java.lang.Object invokeWatchsomuch(@org.jetbrains.annotations.Nullable java.lang.String r34, @org.jetbrains.annotations.Nullable java.lang.Integer r35, @org.jetbrains.annotations.Nullable java.lang.Integer r36, @org.jetbrains.annotations.NotNull kotlin.jvm.functions.Function1<? super com.lagradost.cloudstream3.SubtitleFile, kotlin.Unit> r37, @org.jetbrains.annotations.NotNull kotlin.coroutines.Continuation<? super kotlin.Unit> r38) {
        /*
            Method dump skipped, instruction units count: 1274
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.phisher98.SubsExtractors.invokeWatchsomuch(java.lang.String, java.lang.Integer, java.lang.Integer, kotlin.jvm.functions.Function1, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX INFO: compiled from: SubsExtractors.kt */
    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B;\u0012\u0018\b\u0003\u0010\u0002\u001a\u0004\u0018\u00010\u0003:\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u0002\u0012\u0018\b\u0003\u0010\u0006\u001a\u0004\u0018\u00010\u0003:\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u0006¢\u0006\u0004\b\u0007\u0010\bJ\u000b\u0010\f\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\r\u001a\u0004\u0018\u00010\u0003HÆ\u0003J=\u0010\u000e\u001a\u00020\u00002\u0018\b\u0003\u0010\u0002\u001a\u0004\u0018\u00010\u0003:\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u00022\u0018\b\u0003\u0010\u0006\u001a\u0004\u0018\u00010\u0003:\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u0006HÆ\u0001J\u0014\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0001HÖ\u0083\u0004J\n\u0010\u0012\u001a\u00020\u0013HÖ\u0081\u0004J\n\u0010\u0014\u001a\u00020\u0003HÖ\u0081\u0004R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\n¨\u0006\u0015"}, d2 = {"Lcom/phisher98/SubsExtractors$OsSubtitles;", "", "url", "", "Lcom/fasterxml/jackson/annotation/JsonProperty;", "value", "lang", "<init>", "(Ljava/lang/String;Ljava/lang/String;)V", "getUrl", "()Ljava/lang/String;", "getLang", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", "toString", "StremioX"}, k = 1, mv = {2, 4, 0}, xi = 48)
    public static final /* data */ class OsSubtitles {

        @Nullable
        private final String lang;

        @Nullable
        private final String url;

        /* JADX WARN: Illegal instructions before constructor call */
        public OsSubtitles() {
            String str = null;
            this(str, str, 3, str);
        }

        public static /* synthetic */ OsSubtitles copy$default(OsSubtitles osSubtitles, String str, String str2, int i, Object obj) {
            if ((i & 1) != 0) {
                str = osSubtitles.url;
            }
            if ((i & 2) != 0) {
                str2 = osSubtitles.lang;
            }
            return osSubtitles.copy(str, str2);
        }

        @Nullable
        /* JADX INFO: renamed from: component1, reason: from getter */
        public final String getUrl() {
            return this.url;
        }

        @Nullable
        /* JADX INFO: renamed from: component2, reason: from getter */
        public final String getLang() {
            return this.lang;
        }

        @NotNull
        public final OsSubtitles copy(@JsonProperty("url") @Nullable String url, @JsonProperty("lang") @Nullable String lang) {
            return new OsSubtitles(url, lang);
        }

        public boolean equals(@Nullable Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof OsSubtitles)) {
                return false;
            }
            OsSubtitles osSubtitles = (OsSubtitles) other;
            return Intrinsics.areEqual(this.url, osSubtitles.url) && Intrinsics.areEqual(this.lang, osSubtitles.lang);
        }

        public int hashCode() {
            return ((this.url == null ? 0 : this.url.hashCode()) * 31) + (this.lang != null ? this.lang.hashCode() : 0);
        }

        @NotNull
        public String toString() {
            return "OsSubtitles(url=" + this.url + ", lang=" + this.lang + ')';
        }

        public OsSubtitles(@JsonProperty("url") @Nullable String url, @JsonProperty("lang") @Nullable String lang) {
            this.url = url;
            this.lang = lang;
        }

        public /* synthetic */ OsSubtitles(String str, String str2, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this((i & 1) != 0 ? null : str, (i & 2) != 0 ? null : str2);
        }

        @Nullable
        public final String getUrl() {
            return this.url;
        }

        @Nullable
        public final String getLang() {
            return this.lang;
        }
    }

    /* JADX INFO: compiled from: SubsExtractors.kt */
    @Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B3\u0012*\b\u0003\u0010\u0002\u001a\u0016\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003j\n\u0012\u0004\u0012\u00020\u0004\u0018\u0001`\u0005:\f\b\u0006\u0012\b\b\u0007\u0012\u0004\b\b(\u0002¢\u0006\u0004\b\b\u0010\tJ\u001d\u0010\f\u001a\u0016\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003j\n\u0012\u0004\u0012\u00020\u0004\u0018\u0001`\u0005HÆ\u0003J5\u0010\r\u001a\u00020\u00002*\b\u0003\u0010\u0002\u001a\u0016\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003j\n\u0012\u0004\u0012\u00020\u0004\u0018\u0001`\u0005:\f\b\u0006\u0012\b\b\u0007\u0012\u0004\b\b(\u0002HÆ\u0001J\u0014\u0010\u000e\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0001HÖ\u0083\u0004J\n\u0010\u0011\u001a\u00020\u0012HÖ\u0081\u0004J\n\u0010\u0013\u001a\u00020\u0014HÖ\u0081\u0004R%\u0010\u0002\u001a\u0016\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003j\n\u0012\u0004\u0012\u00020\u0004\u0018\u0001`\u0005¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\u0015"}, d2 = {"Lcom/phisher98/SubsExtractors$OsResult;", "", "subtitles", "Ljava/util/ArrayList;", "Lcom/phisher98/SubsExtractors$OsSubtitles;", "Lkotlin/collections/ArrayList;", "Lcom/fasterxml/jackson/annotation/JsonProperty;", "value", "<init>", "(Ljava/util/ArrayList;)V", "getSubtitles", "()Ljava/util/ArrayList;", "component1", "copy", "equals", "", "other", "hashCode", "", "toString", "", "StremioX"}, k = 1, mv = {2, 4, 0}, xi = 48)
    public static final /* data */ class OsResult {

        @Nullable
        private final ArrayList<OsSubtitles> subtitles;

        /* JADX WARN: Illegal instructions before constructor call */
        public OsResult() {
            ArrayList arrayList = null;
            this(arrayList, 1, arrayList);
        }

        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ OsResult copy$default(OsResult osResult, ArrayList arrayList, int i, Object obj) {
            if ((i & 1) != 0) {
                arrayList = osResult.subtitles;
            }
            return osResult.copy(arrayList);
        }

        @Nullable
        public final ArrayList<OsSubtitles> component1() {
            return this.subtitles;
        }

        @NotNull
        public final OsResult copy(@JsonProperty("subtitles") @Nullable ArrayList<OsSubtitles> subtitles) {
            return new OsResult(subtitles);
        }

        public boolean equals(@Nullable Object other) {
            if (this == other) {
                return true;
            }
            return (other instanceof OsResult) && Intrinsics.areEqual(this.subtitles, ((OsResult) other).subtitles);
        }

        public int hashCode() {
            if (this.subtitles == null) {
                return 0;
            }
            return this.subtitles.hashCode();
        }

        @NotNull
        public String toString() {
            return "OsResult(subtitles=" + this.subtitles + ')';
        }

        public OsResult(@JsonProperty("subtitles") @Nullable ArrayList<OsSubtitles> arrayList) {
            this.subtitles = arrayList;
        }

        public /* synthetic */ OsResult(ArrayList arrayList, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this((i & 1) != 0 ? new ArrayList() : arrayList);
        }

        @Nullable
        public final ArrayList<OsSubtitles> getSubtitles() {
            return this.subtitles;
        }
    }

    /* JADX INFO: compiled from: SubsExtractors.kt */
    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\b\u0013\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001Bo\u0012\u0018\b\u0003\u0010\u0002\u001a\u0004\u0018\u00010\u0003:\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u0002\u0012\u0018\b\u0003\u0010\u0006\u001a\u0004\u0018\u00010\u0003:\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u0006\u0012\u0018\b\u0003\u0010\u0007\u001a\u0004\u0018\u00010\u0003:\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u0007\u0012\u0018\b\u0003\u0010\b\u001a\u0004\u0018\u00010\u0003:\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\b¢\u0006\u0004\b\t\u0010\nJ\u0010\u0010\u0011\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\fJ\u0010\u0010\u0012\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\fJ\u0010\u0010\u0013\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\fJ\u0010\u0010\u0014\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\fJv\u0010\u0015\u001a\u00020\u00002\u0018\b\u0003\u0010\u0002\u001a\u0004\u0018\u00010\u0003:\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u00022\u0018\b\u0003\u0010\u0006\u001a\u0004\u0018\u00010\u0003:\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u00062\u0018\b\u0003\u0010\u0007\u001a\u0004\u0018\u00010\u0003:\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u00072\u0018\b\u0003\u0010\b\u001a\u0004\u0018\u00010\u0003:\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\bHÆ\u0001¢\u0006\u0002\u0010\u0016J\u0014\u0010\u0017\u001a\u00020\u00182\b\u0010\u0019\u001a\u0004\u0018\u00010\u0001HÖ\u0083\u0004J\n\u0010\u001a\u001a\u00020\u0003HÖ\u0081\u0004J\n\u0010\u001b\u001a\u00020\u001cHÖ\u0081\u0004R\u0015\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\n\n\u0002\u0010\r\u001a\u0004\b\u000b\u0010\fR\u0015\u0010\u0006\u001a\u0004\u0018\u00010\u0003¢\u0006\n\n\u0002\u0010\r\u001a\u0004\b\u000e\u0010\fR\u0015\u0010\u0007\u001a\u0004\u0018\u00010\u0003¢\u0006\n\n\u0002\u0010\r\u001a\u0004\b\u000f\u0010\fR\u0015\u0010\b\u001a\u0004\u0018\u00010\u0003¢\u0006\n\n\u0002\u0010\r\u001a\u0004\b\u0010\u0010\f¨\u0006\u001d"}, d2 = {"Lcom/phisher98/SubsExtractors$WatchsomuchTorrents;", "", "id", "", "Lcom/fasterxml/jackson/annotation/JsonProperty;", "value", "movieId", "season", "episode", "<init>", "(Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;)V", "getId", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "getMovieId", "getSeason", "getEpisode", "component1", "component2", "component3", "component4", "copy", "(Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;)Lcom/phisher98/SubsExtractors$WatchsomuchTorrents;", "equals", "", "other", "hashCode", "toString", "", "StremioX"}, k = 1, mv = {2, 4, 0}, xi = 48)
    public static final /* data */ class WatchsomuchTorrents {

        @Nullable
        private final Integer episode;

        @Nullable
        private final Integer id;

        @Nullable
        private final Integer movieId;

        @Nullable
        private final Integer season;

        public WatchsomuchTorrents() {
            this(null, null, null, null, 15, null);
        }

        public static /* synthetic */ WatchsomuchTorrents copy$default(WatchsomuchTorrents watchsomuchTorrents, Integer num, Integer num2, Integer num3, Integer num4, int i, Object obj) {
            if ((i & 1) != 0) {
                num = watchsomuchTorrents.id;
            }
            if ((i & 2) != 0) {
                num2 = watchsomuchTorrents.movieId;
            }
            if ((i & 4) != 0) {
                num3 = watchsomuchTorrents.season;
            }
            if ((i & 8) != 0) {
                num4 = watchsomuchTorrents.episode;
            }
            return watchsomuchTorrents.copy(num, num2, num3, num4);
        }

        @Nullable
        /* JADX INFO: renamed from: component1, reason: from getter */
        public final Integer getId() {
            return this.id;
        }

        @Nullable
        /* JADX INFO: renamed from: component2, reason: from getter */
        public final Integer getMovieId() {
            return this.movieId;
        }

        @Nullable
        /* JADX INFO: renamed from: component3, reason: from getter */
        public final Integer getSeason() {
            return this.season;
        }

        @Nullable
        /* JADX INFO: renamed from: component4, reason: from getter */
        public final Integer getEpisode() {
            return this.episode;
        }

        @NotNull
        public final WatchsomuchTorrents copy(@JsonProperty("id") @Nullable Integer id, @JsonProperty("movieId") @Nullable Integer movieId, @JsonProperty("season") @Nullable Integer season, @JsonProperty("episode") @Nullable Integer episode) {
            return new WatchsomuchTorrents(id, movieId, season, episode);
        }

        public boolean equals(@Nullable Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof WatchsomuchTorrents)) {
                return false;
            }
            WatchsomuchTorrents watchsomuchTorrents = (WatchsomuchTorrents) other;
            return Intrinsics.areEqual(this.id, watchsomuchTorrents.id) && Intrinsics.areEqual(this.movieId, watchsomuchTorrents.movieId) && Intrinsics.areEqual(this.season, watchsomuchTorrents.season) && Intrinsics.areEqual(this.episode, watchsomuchTorrents.episode);
        }

        public int hashCode() {
            return ((((((this.id == null ? 0 : this.id.hashCode()) * 31) + (this.movieId == null ? 0 : this.movieId.hashCode())) * 31) + (this.season == null ? 0 : this.season.hashCode())) * 31) + (this.episode != null ? this.episode.hashCode() : 0);
        }

        @NotNull
        public String toString() {
            return "WatchsomuchTorrents(id=" + this.id + ", movieId=" + this.movieId + ", season=" + this.season + ", episode=" + this.episode + ')';
        }

        public WatchsomuchTorrents(@JsonProperty("id") @Nullable Integer id, @JsonProperty("movieId") @Nullable Integer movieId, @JsonProperty("season") @Nullable Integer season, @JsonProperty("episode") @Nullable Integer episode) {
            this.id = id;
            this.movieId = movieId;
            this.season = season;
            this.episode = episode;
        }

        public /* synthetic */ WatchsomuchTorrents(Integer num, Integer num2, Integer num3, Integer num4, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this((i & 1) != 0 ? null : num, (i & 2) != 0 ? null : num2, (i & 4) != 0 ? null : num3, (i & 8) != 0 ? null : num4);
        }

        @Nullable
        public final Integer getId() {
            return this.id;
        }

        @Nullable
        public final Integer getMovieId() {
            return this.movieId;
        }

        @Nullable
        public final Integer getSeason() {
            return this.season;
        }

        @Nullable
        public final Integer getEpisode() {
            return this.episode;
        }
    }

    /* JADX INFO: compiled from: SubsExtractors.kt */
    @Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B3\u0012*\b\u0003\u0010\u0002\u001a\u0016\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003j\n\u0012\u0004\u0012\u00020\u0004\u0018\u0001`\u0005:\f\b\u0006\u0012\b\b\u0007\u0012\u0004\b\b(\u0002¢\u0006\u0004\b\b\u0010\tJ\u001d\u0010\f\u001a\u0016\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003j\n\u0012\u0004\u0012\u00020\u0004\u0018\u0001`\u0005HÆ\u0003J5\u0010\r\u001a\u00020\u00002*\b\u0003\u0010\u0002\u001a\u0016\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003j\n\u0012\u0004\u0012\u00020\u0004\u0018\u0001`\u0005:\f\b\u0006\u0012\b\b\u0007\u0012\u0004\b\b(\u0002HÆ\u0001J\u0014\u0010\u000e\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0001HÖ\u0083\u0004J\n\u0010\u0011\u001a\u00020\u0012HÖ\u0081\u0004J\n\u0010\u0013\u001a\u00020\u0014HÖ\u0081\u0004R%\u0010\u0002\u001a\u0016\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003j\n\u0012\u0004\u0012\u00020\u0004\u0018\u0001`\u0005¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\u0015"}, d2 = {"Lcom/phisher98/SubsExtractors$WatchsomuchMovies;", "", "torrents", "Ljava/util/ArrayList;", "Lcom/phisher98/SubsExtractors$WatchsomuchTorrents;", "Lkotlin/collections/ArrayList;", "Lcom/fasterxml/jackson/annotation/JsonProperty;", "value", "<init>", "(Ljava/util/ArrayList;)V", "getTorrents", "()Ljava/util/ArrayList;", "component1", "copy", "equals", "", "other", "hashCode", "", "toString", "", "StremioX"}, k = 1, mv = {2, 4, 0}, xi = 48)
    public static final /* data */ class WatchsomuchMovies {

        @Nullable
        private final ArrayList<WatchsomuchTorrents> torrents;

        /* JADX WARN: Illegal instructions before constructor call */
        public WatchsomuchMovies() {
            ArrayList arrayList = null;
            this(arrayList, 1, arrayList);
        }

        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ WatchsomuchMovies copy$default(WatchsomuchMovies watchsomuchMovies, ArrayList arrayList, int i, Object obj) {
            if ((i & 1) != 0) {
                arrayList = watchsomuchMovies.torrents;
            }
            return watchsomuchMovies.copy(arrayList);
        }

        @Nullable
        public final ArrayList<WatchsomuchTorrents> component1() {
            return this.torrents;
        }

        @NotNull
        public final WatchsomuchMovies copy(@JsonProperty("torrents") @Nullable ArrayList<WatchsomuchTorrents> torrents) {
            return new WatchsomuchMovies(torrents);
        }

        public boolean equals(@Nullable Object other) {
            if (this == other) {
                return true;
            }
            return (other instanceof WatchsomuchMovies) && Intrinsics.areEqual(this.torrents, ((WatchsomuchMovies) other).torrents);
        }

        public int hashCode() {
            if (this.torrents == null) {
                return 0;
            }
            return this.torrents.hashCode();
        }

        @NotNull
        public String toString() {
            return "WatchsomuchMovies(torrents=" + this.torrents + ')';
        }

        public WatchsomuchMovies(@JsonProperty("torrents") @Nullable ArrayList<WatchsomuchTorrents> arrayList) {
            this.torrents = arrayList;
        }

        public /* synthetic */ WatchsomuchMovies(ArrayList arrayList, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this((i & 1) != 0 ? new ArrayList() : arrayList);
        }

        @Nullable
        public final ArrayList<WatchsomuchTorrents> getTorrents() {
            return this.torrents;
        }
    }

    /* JADX INFO: compiled from: SubsExtractors.kt */
    @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B!\u0012\u0018\b\u0003\u0010\u0002\u001a\u0004\u0018\u00010\u0003:\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u0002¢\u0006\u0004\b\u0006\u0010\u0007J\u000b\u0010\n\u001a\u0004\u0018\u00010\u0003HÆ\u0003J#\u0010\u000b\u001a\u00020\u00002\u0018\b\u0003\u0010\u0002\u001a\u0004\u0018\u00010\u0003:\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u0002HÆ\u0001J\u0014\u0010\f\u001a\u00020\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u0001HÖ\u0083\u0004J\n\u0010\u000f\u001a\u00020\u0010HÖ\u0081\u0004J\n\u0010\u0011\u001a\u00020\u0012HÖ\u0081\u0004R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\t¨\u0006\u0013"}, d2 = {"Lcom/phisher98/SubsExtractors$WatchsomuchResponses;", "", "movie", "Lcom/phisher98/SubsExtractors$WatchsomuchMovies;", "Lcom/fasterxml/jackson/annotation/JsonProperty;", "value", "<init>", "(Lcom/phisher98/SubsExtractors$WatchsomuchMovies;)V", "getMovie", "()Lcom/phisher98/SubsExtractors$WatchsomuchMovies;", "component1", "copy", "equals", "", "other", "hashCode", "", "toString", "", "StremioX"}, k = 1, mv = {2, 4, 0}, xi = 48)
    public static final /* data */ class WatchsomuchResponses {

        @Nullable
        private final WatchsomuchMovies movie;

        /* JADX WARN: Illegal instructions before constructor call */
        public WatchsomuchResponses() {
            WatchsomuchMovies watchsomuchMovies = null;
            this(watchsomuchMovies, 1, watchsomuchMovies);
        }

        public static /* synthetic */ WatchsomuchResponses copy$default(WatchsomuchResponses watchsomuchResponses, WatchsomuchMovies watchsomuchMovies, int i, Object obj) {
            if ((i & 1) != 0) {
                watchsomuchMovies = watchsomuchResponses.movie;
            }
            return watchsomuchResponses.copy(watchsomuchMovies);
        }

        @Nullable
        /* JADX INFO: renamed from: component1, reason: from getter */
        public final WatchsomuchMovies getMovie() {
            return this.movie;
        }

        @NotNull
        public final WatchsomuchResponses copy(@JsonProperty("movie") @Nullable WatchsomuchMovies movie) {
            return new WatchsomuchResponses(movie);
        }

        public boolean equals(@Nullable Object other) {
            if (this == other) {
                return true;
            }
            return (other instanceof WatchsomuchResponses) && Intrinsics.areEqual(this.movie, ((WatchsomuchResponses) other).movie);
        }

        public int hashCode() {
            if (this.movie == null) {
                return 0;
            }
            return this.movie.hashCode();
        }

        @NotNull
        public String toString() {
            return "WatchsomuchResponses(movie=" + this.movie + ')';
        }

        public WatchsomuchResponses(@JsonProperty("movie") @Nullable WatchsomuchMovies movie) {
            this.movie = movie;
        }

        public /* synthetic */ WatchsomuchResponses(WatchsomuchMovies watchsomuchMovies, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this((i & 1) != 0 ? null : watchsomuchMovies);
        }

        @Nullable
        public final WatchsomuchMovies getMovie() {
            return this.movie;
        }
    }

    /* JADX INFO: compiled from: SubsExtractors.kt */
    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B;\u0012\u0018\b\u0003\u0010\u0002\u001a\u0004\u0018\u00010\u0003:\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u0002\u0012\u0018\b\u0003\u0010\u0006\u001a\u0004\u0018\u00010\u0003:\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u0006¢\u0006\u0004\b\u0007\u0010\bJ\u000b\u0010\f\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\r\u001a\u0004\u0018\u00010\u0003HÆ\u0003J=\u0010\u000e\u001a\u00020\u00002\u0018\b\u0003\u0010\u0002\u001a\u0004\u0018\u00010\u0003:\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u00022\u0018\b\u0003\u0010\u0006\u001a\u0004\u0018\u00010\u0003:\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u0006HÆ\u0001J\u0014\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0001HÖ\u0083\u0004J\n\u0010\u0012\u001a\u00020\u0013HÖ\u0081\u0004J\n\u0010\u0014\u001a\u00020\u0003HÖ\u0081\u0004R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\n¨\u0006\u0015"}, d2 = {"Lcom/phisher98/SubsExtractors$WatchsomuchSubtitles;", "", "url", "", "Lcom/fasterxml/jackson/annotation/JsonProperty;", "value", "label", "<init>", "(Ljava/lang/String;Ljava/lang/String;)V", "getUrl", "()Ljava/lang/String;", "getLabel", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", "toString", "StremioX"}, k = 1, mv = {2, 4, 0}, xi = 48)
    public static final /* data */ class WatchsomuchSubtitles {

        @Nullable
        private final String label;

        @Nullable
        private final String url;

        /* JADX WARN: Illegal instructions before constructor call */
        public WatchsomuchSubtitles() {
            String str = null;
            this(str, str, 3, str);
        }

        public static /* synthetic */ WatchsomuchSubtitles copy$default(WatchsomuchSubtitles watchsomuchSubtitles, String str, String str2, int i, Object obj) {
            if ((i & 1) != 0) {
                str = watchsomuchSubtitles.url;
            }
            if ((i & 2) != 0) {
                str2 = watchsomuchSubtitles.label;
            }
            return watchsomuchSubtitles.copy(str, str2);
        }

        @Nullable
        /* JADX INFO: renamed from: component1, reason: from getter */
        public final String getUrl() {
            return this.url;
        }

        @Nullable
        /* JADX INFO: renamed from: component2, reason: from getter */
        public final String getLabel() {
            return this.label;
        }

        @NotNull
        public final WatchsomuchSubtitles copy(@JsonProperty("url") @Nullable String url, @JsonProperty("label") @Nullable String label) {
            return new WatchsomuchSubtitles(url, label);
        }

        public boolean equals(@Nullable Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof WatchsomuchSubtitles)) {
                return false;
            }
            WatchsomuchSubtitles watchsomuchSubtitles = (WatchsomuchSubtitles) other;
            return Intrinsics.areEqual(this.url, watchsomuchSubtitles.url) && Intrinsics.areEqual(this.label, watchsomuchSubtitles.label);
        }

        public int hashCode() {
            return ((this.url == null ? 0 : this.url.hashCode()) * 31) + (this.label != null ? this.label.hashCode() : 0);
        }

        @NotNull
        public String toString() {
            return "WatchsomuchSubtitles(url=" + this.url + ", label=" + this.label + ')';
        }

        public WatchsomuchSubtitles(@JsonProperty("url") @Nullable String url, @JsonProperty("label") @Nullable String label) {
            this.url = url;
            this.label = label;
        }

        public /* synthetic */ WatchsomuchSubtitles(String str, String str2, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this((i & 1) != 0 ? null : str, (i & 2) != 0 ? null : str2);
        }

        @Nullable
        public final String getUrl() {
            return this.url;
        }

        @Nullable
        public final String getLabel() {
            return this.label;
        }
    }

    /* JADX INFO: compiled from: SubsExtractors.kt */
    @Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B3\u0012*\b\u0003\u0010\u0002\u001a\u0016\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003j\n\u0012\u0004\u0012\u00020\u0004\u0018\u0001`\u0005:\f\b\u0006\u0012\b\b\u0007\u0012\u0004\b\b(\u0002¢\u0006\u0004\b\b\u0010\tJ\u001d\u0010\f\u001a\u0016\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003j\n\u0012\u0004\u0012\u00020\u0004\u0018\u0001`\u0005HÆ\u0003J5\u0010\r\u001a\u00020\u00002*\b\u0003\u0010\u0002\u001a\u0016\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003j\n\u0012\u0004\u0012\u00020\u0004\u0018\u0001`\u0005:\f\b\u0006\u0012\b\b\u0007\u0012\u0004\b\b(\u0002HÆ\u0001J\u0014\u0010\u000e\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0001HÖ\u0083\u0004J\n\u0010\u0011\u001a\u00020\u0012HÖ\u0081\u0004J\n\u0010\u0013\u001a\u00020\u0014HÖ\u0081\u0004R%\u0010\u0002\u001a\u0016\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003j\n\u0012\u0004\u0012\u00020\u0004\u0018\u0001`\u0005¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\u0015"}, d2 = {"Lcom/phisher98/SubsExtractors$WatchsomuchSubResponses;", "", "subtitles", "Ljava/util/ArrayList;", "Lcom/phisher98/SubsExtractors$WatchsomuchSubtitles;", "Lkotlin/collections/ArrayList;", "Lcom/fasterxml/jackson/annotation/JsonProperty;", "value", "<init>", "(Ljava/util/ArrayList;)V", "getSubtitles", "()Ljava/util/ArrayList;", "component1", "copy", "equals", "", "other", "hashCode", "", "toString", "", "StremioX"}, k = 1, mv = {2, 4, 0}, xi = 48)
    public static final /* data */ class WatchsomuchSubResponses {

        @Nullable
        private final ArrayList<WatchsomuchSubtitles> subtitles;

        /* JADX WARN: Illegal instructions before constructor call */
        public WatchsomuchSubResponses() {
            ArrayList arrayList = null;
            this(arrayList, 1, arrayList);
        }

        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ WatchsomuchSubResponses copy$default(WatchsomuchSubResponses watchsomuchSubResponses, ArrayList arrayList, int i, Object obj) {
            if ((i & 1) != 0) {
                arrayList = watchsomuchSubResponses.subtitles;
            }
            return watchsomuchSubResponses.copy(arrayList);
        }

        @Nullable
        public final ArrayList<WatchsomuchSubtitles> component1() {
            return this.subtitles;
        }

        @NotNull
        public final WatchsomuchSubResponses copy(@JsonProperty("subtitles") @Nullable ArrayList<WatchsomuchSubtitles> subtitles) {
            return new WatchsomuchSubResponses(subtitles);
        }

        public boolean equals(@Nullable Object other) {
            if (this == other) {
                return true;
            }
            return (other instanceof WatchsomuchSubResponses) && Intrinsics.areEqual(this.subtitles, ((WatchsomuchSubResponses) other).subtitles);
        }

        public int hashCode() {
            if (this.subtitles == null) {
                return 0;
            }
            return this.subtitles.hashCode();
        }

        @NotNull
        public String toString() {
            return "WatchsomuchSubResponses(subtitles=" + this.subtitles + ')';
        }

        public WatchsomuchSubResponses(@JsonProperty("subtitles") @Nullable ArrayList<WatchsomuchSubtitles> arrayList) {
            this.subtitles = arrayList;
        }

        public /* synthetic */ WatchsomuchSubResponses(ArrayList arrayList, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this((i & 1) != 0 ? new ArrayList() : arrayList);
        }

        @Nullable
        public final ArrayList<WatchsomuchSubtitles> getSubtitles() {
            return this.subtitles;
        }
    }
}
