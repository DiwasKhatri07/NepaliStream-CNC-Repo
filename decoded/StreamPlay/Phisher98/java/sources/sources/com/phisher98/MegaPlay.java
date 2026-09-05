package com.phisher98;

import com.lagradost.cloudstream3.SubtitleFile;
import com.lagradost.cloudstream3.utils.ExtractorApi;
import com.lagradost.cloudstream3.utils.ExtractorLink;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: Extractors.kt */
/* JADX INFO: loaded from: /home/ubuntu/work/NepaliStream-CNC-Repo/decoded/phisher98/StreamPlay/classes.dex */
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0016\u0018\u00002\u00020\u0001:\u0005\u0018\u0019\u001a\u001b\u001cB\u0007¢\u0006\u0004\b\u0002\u0010\u0003JH\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u00052\b\u0010\u0011\u001a\u0004\u0018\u00010\u00052\u0012\u0010\u0012\u001a\u000e\u0012\u0004\u0012\u00020\u0014\u0012\u0004\u0012\u00020\u000f0\u00132\u0012\u0010\u0015\u001a\u000e\u0012\u0004\u0012\u00020\u0016\u0012\u0004\u0012\u00020\u000f0\u0013H\u0096@¢\u0006\u0002\u0010\u0017R\u0014\u0010\u0004\u001a\u00020\u0005X\u0096D¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u0014\u0010\b\u001a\u00020\u0005X\u0096D¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\u0007R\u0014\u0010\n\u001a\u00020\u000bX\u0096D¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\r¨\u0006\u001d"}, d2 = {"Lcom/phisher98/MegaPlay;", "Lcom/lagradost/cloudstream3/utils/ExtractorApi;", "<init>", "()V", "name", "", "getName", "()Ljava/lang/String;", "mainUrl", "getMainUrl", "requiresReferer", "", "getRequiresReferer", "()Z", "getUrl", "", "url", "referer", "subtitleCallback", "Lkotlin/Function1;", "Lcom/lagradost/cloudstream3/SubtitleFile;", "callback", "Lcom/lagradost/cloudstream3/utils/ExtractorLink;", "(Ljava/lang/String;Ljava/lang/String;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "MegaPlayResponse", "Source", "Track", "Intro", "Outro", "StreamPlay"}, k = 1, mv = {2, 4, 0}, xi = 48)
@SourceDebugExtension({"SMAP\nExtractors.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Extractors.kt\ncom/phisher98/MegaPlay\n+ 2 NiceResponse.kt\ncom/lagradost/nicehttp/NiceResponse\n+ 3 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,4003:1\n73#2,5:4004\n2068#3,2:4009\n2068#3,2:4011\n*S KotlinDebug\n*F\n+ 1 Extractors.kt\ncom/phisher98/MegaPlay\n*L\n3196#1:4004,5\n3202#1:4009,2\n3204#1:4011,2\n*E\n"})
public class MegaPlay extends ExtractorApi {
    private final boolean requiresReferer;

    @NotNull
    private final String name = "MegaPlay";

    @NotNull
    private final String mainUrl = "https://megaplay.buzz";

    /* JADX INFO: renamed from: com.phisher98.MegaPlay$getUrl$1 */
    /* JADX INFO: compiled from: Extractors.kt */
    @Metadata(k = 3, mv = {2, 4, 0}, xi = 48)
    @DebugMetadata(c = "com.phisher98.MegaPlay", f = "Extractors.kt", i = {0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3}, l = {3179, 3195, 3201, 3210}, m = "getUrl$suspendImpl", n = {"$this", "url", "referer", "subtitleCallback", "callback", "mainHeaders", "headers", "$this", "url", "referer", "subtitleCallback", "callback", "mainHeaders", "headers", "page", "id", "apiUrl", "$this", "url", "referer", "subtitleCallback", "callback", "mainHeaders", "headers", "page", "id", "apiUrl", "response", "m3u8", "$this", "url", "referer", "subtitleCallback", "callback", "mainHeaders", "headers", "page", "id", "apiUrl", "response", "m3u8", "$this$forEach$iv", "element$iv", "track", "label", "file"}, nl = {3181, 3196, 3202, 3209}, s = {"L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$6", "L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$6", "L$7", "L$8", "L$9", "L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$6", "L$7", "L$8", "L$9", "L$10", "L$11", "L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$6", "L$7", "L$8", "L$9", "L$10", "L$11", "L$12", "L$14", "L$15", "L$16", "L$17"}, v = 2)
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

        C00451(Continuation<? super C00451> continuation) {
            super(continuation);
        }

        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return MegaPlay.getUrl$suspendImpl(MegaPlay.this, null, null, null, null, (Continuation) this);
        }
    }

    @Nullable
    public Object getUrl(@NotNull String str, @Nullable String str2, @NotNull Function1<? super SubtitleFile, Unit> function1, @NotNull Function1<? super ExtractorLink, Unit> function2, @NotNull Continuation<? super Unit> continuation) {
        return getUrl$suspendImpl(this, str, str2, function1, function2, continuation);
    }

    @NotNull
    public String getName() {
        return this.name;
    }

    @NotNull
    public String getMainUrl() {
        return this.mainUrl;
    }

    public boolean getRequiresReferer() {
        return this.requiresReferer;
    }

    /* JADX WARN: Code duplicated, block: B:108:0x0484 A[Catch: Exception -> 0x05d2, TRY_LEAVE, TryCatch #10 {Exception -> 0x05d2, blocks: (B:106:0x047e, B:108:0x0484), top: B:187:0x047e }] */
    /* JADX WARN: Code duplicated, block: B:115:0x04ab  */
    /* JADX WARN: Code duplicated, block: B:185:0x049e A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:7:0x0018  */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Path cross not found for [B:185:0x049e, B:118:0x04bd], limit reached: 198 */
    /* JADX WARN: Type inference failed for: r11v1 */
    /* JADX WARN: Type inference failed for: r26v0 */
    /* JADX WARN: Type inference failed for: r26v1 */
    /* JADX WARN: Type inference failed for: r26v11 */
    /* JADX WARN: Type inference failed for: r26v12 */
    /* JADX WARN: Type inference failed for: r26v16 */
    /* JADX WARN: Type inference failed for: r26v17 */
    /* JADX WARN: Type inference failed for: r26v18 */
    /* JADX WARN: Type inference failed for: r26v19 */
    /* JADX WARN: Type inference failed for: r26v2 */
    /* JADX WARN: Type inference failed for: r26v20 */
    /* JADX WARN: Type inference failed for: r26v24 */
    /* JADX WARN: Type inference failed for: r26v27 */
    /* JADX WARN: Type inference failed for: r26v28 */
    /* JADX WARN: Type inference failed for: r26v29 */
    /* JADX WARN: Type inference failed for: r26v3 */
    /* JADX WARN: Type inference failed for: r26v5 */
    /* JADX WARN: Type inference failed for: r26v6 */
    /* JADX WARN: Type inference failed for: r26v8 */
    /* JADX WARN: Type inference failed for: r26v9 */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:115:0x04ab -> B:135:0x05a1). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:120:0x04c3 -> B:135:0x05a1). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:131:0x0560 -> B:175:0x0584). Please report as a decompilation issue!!! */
    /*  JADX ERROR: StackOverflowError in pass: RegionMakerVisitor
        java.lang.StackOverflowError
        	at jadx.core.utils.BlockUtils.traverseSuccessorsUntil(BlockUtils.java:731)
        	at jadx.core.utils.BlockUtils.traverseSuccessorsUntil(BlockUtils.java:749)
        */
    static /* synthetic */ java.lang.Object getUrl$suspendImpl(com.phisher98.MegaPlay r28, java.lang.String r29, java.lang.String r30, kotlin.jvm.functions.Function1<? super com.lagradost.cloudstream3.SubtitleFile, kotlin.Unit> r31, kotlin.jvm.functions.Function1<? super com.lagradost.cloudstream3.utils.ExtractorLink, kotlin.Unit> r32, kotlin.coroutines.Continuation<? super kotlin.Unit> r33) {
        /*
            Method dump skipped, instruction units count: 1694
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.phisher98.MegaPlay.getUrl$suspendImpl(com.phisher98.MegaPlay, java.lang.String, java.lang.String, kotlin.jvm.functions.Function1, kotlin.jvm.functions.Function1, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX INFO: compiled from: Extractors.kt */
    @Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u001a\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001BO\u0012\u000e\u0010\u0002\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003\u0012\u000e\u0010\u0005\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0003\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\b\u0012\b\u0010\t\u001a\u0004\u0018\u00010\n\u0012\b\u0010\u000b\u001a\u0004\u0018\u00010\f\u0012\b\u0010\r\u001a\u0004\u0018\u00010\u000e¢\u0006\u0004\b\u000f\u0010\u0010J\u0011\u0010\u001e\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003HÆ\u0003J\u0011\u0010\u001f\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0003HÆ\u0003J\u0010\u0010 \u001a\u0004\u0018\u00010\bHÆ\u0003¢\u0006\u0002\u0010\u0015J\u000b\u0010!\u001a\u0004\u0018\u00010\nHÆ\u0003J\u000b\u0010\"\u001a\u0004\u0018\u00010\fHÆ\u0003J\u0010\u0010#\u001a\u0004\u0018\u00010\u000eHÆ\u0003¢\u0006\u0002\u0010\u001cJb\u0010$\u001a\u00020\u00002\u0010\b\u0002\u0010\u0002\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u00032\u0010\b\u0002\u0010\u0005\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u00032\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b2\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\n2\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\f2\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u000eHÆ\u0001¢\u0006\u0002\u0010%J\u0014\u0010&\u001a\u00020\b2\b\u0010'\u001a\u0004\u0018\u00010\u0001HÖ\u0083\u0004J\n\u0010(\u001a\u00020)HÖ\u0081\u0004J\n\u0010*\u001a\u00020+HÖ\u0081\u0004R\u0019\u0010\u0002\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u0019\u0010\u0005\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0012R\u0015\u0010\u0007\u001a\u0004\u0018\u00010\b¢\u0006\n\n\u0002\u0010\u0016\u001a\u0004\b\u0014\u0010\u0015R\u0013\u0010\t\u001a\u0004\u0018\u00010\n¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0018R\u0013\u0010\u000b\u001a\u0004\u0018\u00010\f¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u001aR\u0015\u0010\r\u001a\u0004\u0018\u00010\u000e¢\u0006\n\n\u0002\u0010\u001d\u001a\u0004\b\u001b\u0010\u001c¨\u0006,"}, d2 = {"Lcom/phisher98/MegaPlay$MegaPlayResponse;", "", "sources", "", "Lcom/phisher98/MegaPlay$Source;", "tracks", "Lcom/phisher98/MegaPlay$Track;", "encrypted", "", "intro", "Lcom/phisher98/MegaPlay$Intro;", "outro", "Lcom/phisher98/MegaPlay$Outro;", "server", "", "<init>", "(Ljava/util/List;Ljava/util/List;Ljava/lang/Boolean;Lcom/phisher98/MegaPlay$Intro;Lcom/phisher98/MegaPlay$Outro;Ljava/lang/Long;)V", "getSources", "()Ljava/util/List;", "getTracks", "getEncrypted", "()Ljava/lang/Boolean;", "Ljava/lang/Boolean;", "getIntro", "()Lcom/phisher98/MegaPlay$Intro;", "getOutro", "()Lcom/phisher98/MegaPlay$Outro;", "getServer", "()Ljava/lang/Long;", "Ljava/lang/Long;", "component1", "component2", "component3", "component4", "component5", "component6", "copy", "(Ljava/util/List;Ljava/util/List;Ljava/lang/Boolean;Lcom/phisher98/MegaPlay$Intro;Lcom/phisher98/MegaPlay$Outro;Ljava/lang/Long;)Lcom/phisher98/MegaPlay$MegaPlayResponse;", "equals", "other", "hashCode", "", "toString", "", "StreamPlay"}, k = 1, mv = {2, 4, 0}, xi = 48)
    public static final /* data */ class MegaPlayResponse {

        @Nullable
        private final Boolean encrypted;

        @Nullable
        private final Intro intro;

        @Nullable
        private final Outro outro;

        @Nullable
        private final Long server;

        @Nullable
        private final List<Source> sources;

        @Nullable
        private final List<Track> tracks;

        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ MegaPlayResponse copy$default(MegaPlayResponse megaPlayResponse, List list, List list2, Boolean bool, Intro intro, Outro outro, Long l, int i, Object obj) {
            if ((i & 1) != 0) {
                list = megaPlayResponse.sources;
            }
            if ((i & 2) != 0) {
                list2 = megaPlayResponse.tracks;
            }
            if ((i & 4) != 0) {
                bool = megaPlayResponse.encrypted;
            }
            if ((i & 8) != 0) {
                intro = megaPlayResponse.intro;
            }
            if ((i & 16) != 0) {
                outro = megaPlayResponse.outro;
            }
            if ((i & 32) != 0) {
                l = megaPlayResponse.server;
            }
            Outro outro2 = outro;
            Long l2 = l;
            return megaPlayResponse.copy(list, list2, bool, intro, outro2, l2);
        }

        @Nullable
        public final List<Source> component1() {
            return this.sources;
        }

        @Nullable
        public final List<Track> component2() {
            return this.tracks;
        }

        @Nullable
        /* JADX INFO: renamed from: component3, reason: from getter */
        public final Boolean getEncrypted() {
            return this.encrypted;
        }

        @Nullable
        /* JADX INFO: renamed from: component4, reason: from getter */
        public final Intro getIntro() {
            return this.intro;
        }

        @Nullable
        /* JADX INFO: renamed from: component5, reason: from getter */
        public final Outro getOutro() {
            return this.outro;
        }

        @Nullable
        /* JADX INFO: renamed from: component6, reason: from getter */
        public final Long getServer() {
            return this.server;
        }

        @NotNull
        public final MegaPlayResponse copy(@Nullable List<Source> sources, @Nullable List<Track> tracks, @Nullable Boolean encrypted, @Nullable Intro intro, @Nullable Outro outro, @Nullable Long server) {
            return new MegaPlayResponse(sources, tracks, encrypted, intro, outro, server);
        }

        public boolean equals(@Nullable Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof MegaPlayResponse)) {
                return false;
            }
            MegaPlayResponse megaPlayResponse = (MegaPlayResponse) other;
            return Intrinsics.areEqual(this.sources, megaPlayResponse.sources) && Intrinsics.areEqual(this.tracks, megaPlayResponse.tracks) && Intrinsics.areEqual(this.encrypted, megaPlayResponse.encrypted) && Intrinsics.areEqual(this.intro, megaPlayResponse.intro) && Intrinsics.areEqual(this.outro, megaPlayResponse.outro) && Intrinsics.areEqual(this.server, megaPlayResponse.server);
        }

        public int hashCode() {
            return ((((((((((this.sources == null ? 0 : this.sources.hashCode()) * 31) + (this.tracks == null ? 0 : this.tracks.hashCode())) * 31) + (this.encrypted == null ? 0 : this.encrypted.hashCode())) * 31) + (this.intro == null ? 0 : this.intro.hashCode())) * 31) + (this.outro == null ? 0 : this.outro.hashCode())) * 31) + (this.server != null ? this.server.hashCode() : 0);
        }

        @NotNull
        public String toString() {
            return "MegaPlayResponse(sources=" + this.sources + ", tracks=" + this.tracks + ", encrypted=" + this.encrypted + ", intro=" + this.intro + ", outro=" + this.outro + ", server=" + this.server + ')';
        }

        public MegaPlayResponse(@Nullable List<Source> list, @Nullable List<Track> list2, @Nullable Boolean encrypted, @Nullable Intro intro, @Nullable Outro outro, @Nullable Long server) {
            this.sources = list;
            this.tracks = list2;
            this.encrypted = encrypted;
            this.intro = intro;
            this.outro = outro;
            this.server = server;
        }

        @Nullable
        public final List<Source> getSources() {
            return this.sources;
        }

        @Nullable
        public final List<Track> getTracks() {
            return this.tracks;
        }

        @Nullable
        public final Boolean getEncrypted() {
            return this.encrypted;
        }

        @Nullable
        public final Intro getIntro() {
            return this.intro;
        }

        @Nullable
        public final Outro getOutro() {
            return this.outro;
        }

        @Nullable
        public final Long getServer() {
            return this.server;
        }
    }

    /* JADX INFO: compiled from: Extractors.kt */
    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\n\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B\u001b\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u0005\u0010\u0006J\u000b\u0010\n\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u000b\u001a\u0004\u0018\u00010\u0003HÆ\u0003J!\u0010\f\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\u0014\u0010\r\u001a\u00020\u000e2\b\u0010\u000f\u001a\u0004\u0018\u00010\u0001HÖ\u0083\u0004J\n\u0010\u0010\u001a\u00020\u0011HÖ\u0081\u0004J\n\u0010\u0012\u001a\u00020\u0003HÖ\u0081\u0004R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\b¨\u0006\u0013"}, d2 = {"Lcom/phisher98/MegaPlay$Source;", "", "file", "", "type", "<init>", "(Ljava/lang/String;Ljava/lang/String;)V", "getFile", "()Ljava/lang/String;", "getType", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", "toString", "StreamPlay"}, k = 1, mv = {2, 4, 0}, xi = 48)
    public static final /* data */ class Source {

        @Nullable
        private final String file;

        @Nullable
        private final String type;

        public static /* synthetic */ Source copy$default(Source source, String str, String str2, int i, Object obj) {
            if ((i & 1) != 0) {
                str = source.file;
            }
            if ((i & 2) != 0) {
                str2 = source.type;
            }
            return source.copy(str, str2);
        }

        @Nullable
        /* JADX INFO: renamed from: component1, reason: from getter */
        public final String getFile() {
            return this.file;
        }

        @Nullable
        /* JADX INFO: renamed from: component2, reason: from getter */
        public final String getType() {
            return this.type;
        }

        @NotNull
        public final Source copy(@Nullable String file, @Nullable String type) {
            return new Source(file, type);
        }

        public boolean equals(@Nullable Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof Source)) {
                return false;
            }
            Source source = (Source) other;
            return Intrinsics.areEqual(this.file, source.file) && Intrinsics.areEqual(this.type, source.type);
        }

        public int hashCode() {
            return ((this.file == null ? 0 : this.file.hashCode()) * 31) + (this.type != null ? this.type.hashCode() : 0);
        }

        @NotNull
        public String toString() {
            return "Source(file=" + this.file + ", type=" + this.type + ')';
        }

        public Source(@Nullable String file, @Nullable String type) {
            this.file = file;
            this.type = type;
        }

        @Nullable
        public final String getFile() {
            return this.file;
        }

        @Nullable
        public final String getType() {
            return this.type;
        }
    }

    /* JADX INFO: compiled from: Extractors.kt */
    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0012\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B/\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\u0004\b\b\u0010\tJ\u000b\u0010\u0011\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0012\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0013\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0010\u0010\u0014\u001a\u0004\u0018\u00010\u0007HÆ\u0003¢\u0006\u0002\u0010\u000fJ>\u0010\u0015\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007HÆ\u0001¢\u0006\u0002\u0010\u0016J\u0014\u0010\u0017\u001a\u00020\u00072\b\u0010\u0018\u001a\u0004\u0018\u00010\u0001HÖ\u0083\u0004J\n\u0010\u0019\u001a\u00020\u001aHÖ\u0081\u0004J\n\u0010\u001b\u001a\u00020\u0003HÖ\u0081\u0004R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\u000bR\u0013\u0010\u0005\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000bR\u0015\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\n\n\u0002\u0010\u0010\u001a\u0004\b\u000e\u0010\u000f¨\u0006\u001c"}, d2 = {"Lcom/phisher98/MegaPlay$Track;", "", "file", "", "label", "kind", "default", "", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Boolean;)V", "getFile", "()Ljava/lang/String;", "getLabel", "getKind", "getDefault", "()Ljava/lang/Boolean;", "Ljava/lang/Boolean;", "component1", "component2", "component3", "component4", "copy", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Boolean;)Lcom/phisher98/MegaPlay$Track;", "equals", "other", "hashCode", "", "toString", "StreamPlay"}, k = 1, mv = {2, 4, 0}, xi = 48)
    public static final /* data */ class Track {

        @Nullable
        private final Boolean default;

        @Nullable
        private final String file;

        @Nullable
        private final String kind;

        @Nullable
        private final String label;

        public static /* synthetic */ Track copy$default(Track track, String str, String str2, String str3, Boolean bool, int i, Object obj) {
            if ((i & 1) != 0) {
                str = track.file;
            }
            if ((i & 2) != 0) {
                str2 = track.label;
            }
            if ((i & 4) != 0) {
                str3 = track.kind;
            }
            if ((i & 8) != 0) {
                bool = track.default;
            }
            return track.copy(str, str2, str3, bool);
        }

        @Nullable
        /* JADX INFO: renamed from: component1, reason: from getter */
        public final String getFile() {
            return this.file;
        }

        @Nullable
        /* JADX INFO: renamed from: component2, reason: from getter */
        public final String getLabel() {
            return this.label;
        }

        @Nullable
        /* JADX INFO: renamed from: component3, reason: from getter */
        public final String getKind() {
            return this.kind;
        }

        @Nullable
        /* JADX INFO: renamed from: component4, reason: from getter */
        public final Boolean getDefault() {
            return this.default;
        }

        @NotNull
        public final Track copy(@Nullable String file, @Nullable String label, @Nullable String kind, @Nullable Boolean bool) {
            return new Track(file, label, kind, bool);
        }

        public boolean equals(@Nullable Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof Track)) {
                return false;
            }
            Track track = (Track) other;
            return Intrinsics.areEqual(this.file, track.file) && Intrinsics.areEqual(this.label, track.label) && Intrinsics.areEqual(this.kind, track.kind) && Intrinsics.areEqual(this.default, track.default);
        }

        public int hashCode() {
            return ((((((this.file == null ? 0 : this.file.hashCode()) * 31) + (this.label == null ? 0 : this.label.hashCode())) * 31) + (this.kind == null ? 0 : this.kind.hashCode())) * 31) + (this.default != null ? this.default.hashCode() : 0);
        }

        @NotNull
        public String toString() {
            return "Track(file=" + this.file + ", label=" + this.label + ", kind=" + this.kind + ", default=" + this.default + ')';
        }

        public Track(@Nullable String file, @Nullable String label, @Nullable String kind, @Nullable Boolean bool) {
            this.file = file;
            this.label = label;
            this.kind = kind;
            this.default = bool;
        }

        @Nullable
        public final String getFile() {
            return this.file;
        }

        @Nullable
        public final String getLabel() {
            return this.label;
        }

        @Nullable
        public final String getKind() {
            return this.kind;
        }

        @Nullable
        public final Boolean getDefault() {
            return this.default;
        }
    }

    /* JADX INFO: compiled from: Extractors.kt */
    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\t\n\u0002\b\f\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\u001b\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u0005\u0010\u0006J\u0010\u0010\u000b\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\bJ\u0010\u0010\f\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\bJ&\u0010\r\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003HÆ\u0001¢\u0006\u0002\u0010\u000eJ\u0014\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0001HÖ\u0083\u0004J\n\u0010\u0012\u001a\u00020\u0013HÖ\u0081\u0004J\n\u0010\u0014\u001a\u00020\u0015HÖ\u0081\u0004R\u0015\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\n\n\u0002\u0010\t\u001a\u0004\b\u0007\u0010\bR\u0015\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\n\n\u0002\u0010\t\u001a\u0004\b\n\u0010\b¨\u0006\u0016"}, d2 = {"Lcom/phisher98/MegaPlay$Intro;", "", "start", "", "end", "<init>", "(Ljava/lang/Long;Ljava/lang/Long;)V", "getStart", "()Ljava/lang/Long;", "Ljava/lang/Long;", "getEnd", "component1", "component2", "copy", "(Ljava/lang/Long;Ljava/lang/Long;)Lcom/phisher98/MegaPlay$Intro;", "equals", "", "other", "hashCode", "", "toString", "", "StreamPlay"}, k = 1, mv = {2, 4, 0}, xi = 48)
    public static final /* data */ class Intro {

        @Nullable
        private final Long end;

        @Nullable
        private final Long start;

        public static /* synthetic */ Intro copy$default(Intro intro, Long l, Long l2, int i, Object obj) {
            if ((i & 1) != 0) {
                l = intro.start;
            }
            if ((i & 2) != 0) {
                l2 = intro.end;
            }
            return intro.copy(l, l2);
        }

        @Nullable
        /* JADX INFO: renamed from: component1, reason: from getter */
        public final Long getStart() {
            return this.start;
        }

        @Nullable
        /* JADX INFO: renamed from: component2, reason: from getter */
        public final Long getEnd() {
            return this.end;
        }

        @NotNull
        public final Intro copy(@Nullable Long start, @Nullable Long end) {
            return new Intro(start, end);
        }

        public boolean equals(@Nullable Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof Intro)) {
                return false;
            }
            Intro intro = (Intro) other;
            return Intrinsics.areEqual(this.start, intro.start) && Intrinsics.areEqual(this.end, intro.end);
        }

        public int hashCode() {
            return ((this.start == null ? 0 : this.start.hashCode()) * 31) + (this.end != null ? this.end.hashCode() : 0);
        }

        @NotNull
        public String toString() {
            return "Intro(start=" + this.start + ", end=" + this.end + ')';
        }

        public Intro(@Nullable Long start, @Nullable Long end) {
            this.start = start;
            this.end = end;
        }

        @Nullable
        public final Long getStart() {
            return this.start;
        }

        @Nullable
        public final Long getEnd() {
            return this.end;
        }
    }

    /* JADX INFO: compiled from: Extractors.kt */
    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\t\n\u0002\b\f\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\u001b\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u0005\u0010\u0006J\u0010\u0010\u000b\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\bJ\u0010\u0010\f\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\bJ&\u0010\r\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003HÆ\u0001¢\u0006\u0002\u0010\u000eJ\u0014\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0001HÖ\u0083\u0004J\n\u0010\u0012\u001a\u00020\u0013HÖ\u0081\u0004J\n\u0010\u0014\u001a\u00020\u0015HÖ\u0081\u0004R\u0015\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\n\n\u0002\u0010\t\u001a\u0004\b\u0007\u0010\bR\u0015\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\n\n\u0002\u0010\t\u001a\u0004\b\n\u0010\b¨\u0006\u0016"}, d2 = {"Lcom/phisher98/MegaPlay$Outro;", "", "start", "", "end", "<init>", "(Ljava/lang/Long;Ljava/lang/Long;)V", "getStart", "()Ljava/lang/Long;", "Ljava/lang/Long;", "getEnd", "component1", "component2", "copy", "(Ljava/lang/Long;Ljava/lang/Long;)Lcom/phisher98/MegaPlay$Outro;", "equals", "", "other", "hashCode", "", "toString", "", "StreamPlay"}, k = 1, mv = {2, 4, 0}, xi = 48)
    public static final /* data */ class Outro {

        @Nullable
        private final Long end;

        @Nullable
        private final Long start;

        public static /* synthetic */ Outro copy$default(Outro outro, Long l, Long l2, int i, Object obj) {
            if ((i & 1) != 0) {
                l = outro.start;
            }
            if ((i & 2) != 0) {
                l2 = outro.end;
            }
            return outro.copy(l, l2);
        }

        @Nullable
        /* JADX INFO: renamed from: component1, reason: from getter */
        public final Long getStart() {
            return this.start;
        }

        @Nullable
        /* JADX INFO: renamed from: component2, reason: from getter */
        public final Long getEnd() {
            return this.end;
        }

        @NotNull
        public final Outro copy(@Nullable Long start, @Nullable Long end) {
            return new Outro(start, end);
        }

        public boolean equals(@Nullable Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof Outro)) {
                return false;
            }
            Outro outro = (Outro) other;
            return Intrinsics.areEqual(this.start, outro.start) && Intrinsics.areEqual(this.end, outro.end);
        }

        public int hashCode() {
            return ((this.start == null ? 0 : this.start.hashCode()) * 31) + (this.end != null ? this.end.hashCode() : 0);
        }

        @NotNull
        public String toString() {
            return "Outro(start=" + this.start + ", end=" + this.end + ')';
        }

        public Outro(@Nullable Long start, @Nullable Long end) {
            this.start = start;
            this.end = end;
        }

        @Nullable
        public final Long getStart() {
            return this.start;
        }

        @Nullable
        public final Long getEnd() {
            return this.end;
        }
    }
}
