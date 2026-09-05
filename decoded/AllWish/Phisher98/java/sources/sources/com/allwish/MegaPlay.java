package com.allwish;

import com.lagradost.api.Log;
import com.lagradost.cloudstream3.SubtitleFile;
import com.lagradost.cloudstream3.utils.ExtractorApi;
import com.lagradost.cloudstream3.utils.ExtractorLink;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlinx.serialization.Serializable;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: Extractors.kt */
/* JADX INFO: loaded from: /home/runner/work/NepaliStream-CNC-Repo/NepaliStream-CNC-Repo/decoded/AllWish/Phisher98/java/classes.dex */
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0016\u0018\u00002\u00020\u0001:\u0003\u0018\u0019\u001aB\u0007¢\u0006\u0004\b\u0002\u0010\u0003JH\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u00052\b\u0010\u0011\u001a\u0004\u0018\u00010\u00052\u0012\u0010\u0012\u001a\u000e\u0012\u0004\u0012\u00020\u0014\u0012\u0004\u0012\u00020\u000f0\u00132\u0012\u0010\u0015\u001a\u000e\u0012\u0004\u0012\u00020\u0016\u0012\u0004\u0012\u00020\u000f0\u0013H\u0096@¢\u0006\u0002\u0010\u0017R\u0014\u0010\u0004\u001a\u00020\u0005X\u0096D¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u0014\u0010\b\u001a\u00020\u0005X\u0096D¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\u0007R\u0014\u0010\n\u001a\u00020\u000bX\u0096D¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\r¨\u0006\u001b"}, d2 = {"Lcom/allwish/MegaPlay;", "Lcom/lagradost/cloudstream3/utils/ExtractorApi;", "<init>", "()V", "name", "", "getName", "()Ljava/lang/String;", "mainUrl", "getMainUrl", "requiresReferer", "", "getRequiresReferer", "()Z", "getUrl", "", "url", "referer", "subtitleCallback", "Lkotlin/Function1;", "Lcom/lagradost/cloudstream3/SubtitleFile;", "callback", "Lcom/lagradost/cloudstream3/utils/ExtractorLink;", "(Ljava/lang/String;Ljava/lang/String;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "MegaPlayResponse", "Sources", "Track", "AllWish"}, k = 1, mv = {2, 4, 0}, xi = 48)
@SourceDebugExtension({"SMAP\nExtractors.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Extractors.kt\ncom/allwish/MegaPlay\n+ 2 NiceResponse.kt\ncom/lagradost/nicehttp/NiceResponse\n+ 3 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,247:1\n73#2,5:248\n2068#3,2:253\n2068#3,2:255\n777#3:257\n873#3,2:258\n2077#3,3:260\n2068#3,2:263\n*S KotlinDebug\n*F\n+ 1 Extractors.kt\ncom/allwish/MegaPlay\n*L\n75#1:248,5\n86#1:253,2\n88#1:255,2\n136#1:257\n136#1:258,2\n137#1:260,3\n146#1:263,2\n*E\n"})
public class MegaPlay extends ExtractorApi {
    private final boolean requiresReferer;

    @NotNull
    private final String name = "MegaPlay";

    @NotNull
    private final String mainUrl = "https://megaplay.buzz";

    /* JADX INFO: renamed from: com.allwish.MegaPlay$getUrl$1 */
    /* JADX INFO: compiled from: Extractors.kt */
    @Metadata(k = 3, mv = {2, 4, 0}, xi = 48)
    @DebugMetadata(c = "com.allwish.MegaPlay", f = "Extractors.kt", i = {0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7}, l = {58, 75, 81, 94, 134, 138, 145, 146}, m = "getUrl$suspendImpl", n = {"$this", "url", "referer", "subtitleCallback", "callback", "mainheaders", "headers", "$this", "url", "referer", "subtitleCallback", "callback", "mainheaders", "headers", "page", "id", "apiUrl", "$this$getUrl_u24lambda_u241", "$this", "url", "referer", "subtitleCallback", "callback", "mainheaders", "headers", "page", "id", "apiUrl", "response", "m3u8", "$this", "url", "referer", "subtitleCallback", "callback", "mainheaders", "headers", "page", "id", "apiUrl", "response", "m3u8", "$this$forEach$iv", "element$iv", "track", "label", "file", "$this", "url", "referer", "subtitleCallback", "callback", "mainheaders", "e", "jsToClickPlay", "m3u8Resolver", "vttResolver", "$this", "url", "referer", "subtitleCallback", "callback", "mainheaders", "e", "jsToClickPlay", "m3u8Resolver", "vttResolver", "vttResponse", "subtitleUrls", "$this$forEachIndexed$iv", "item$iv", "subUrl", "index$iv", "$this", "url", "referer", "subtitleCallback", "callback", "mainheaders", "e", "jsToClickPlay", "m3u8Resolver", "vttResolver", "vttResponse", "subtitleUrls", "$this", "url", "referer", "subtitleCallback", "callback", "mainheaders", "e", "jsToClickPlay", "m3u8Resolver", "vttResolver", "vttResponse", "subtitleUrls", "fallbackM3u8"}, nl = {60, 248, 86, 93, 135, 143, 146, 263}, s = {"L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$6", "L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$6", "L$7", "L$8", "L$9", "L$10", "L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$6", "L$7", "L$8", "L$9", "L$10", "L$11", "L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$6", "L$7", "L$8", "L$9", "L$10", "L$11", "L$12", "L$14", "L$15", "L$16", "L$17", "L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$6", "L$7", "L$8", "L$9", "L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$6", "L$7", "L$8", "L$9", "L$10", "L$11", "L$12", "L$14", "L$15", "I$0", "L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$6", "L$7", "L$8", "L$9", "L$10", "L$11", "L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$6", "L$7", "L$8", "L$9", "L$10", "L$11", "L$12"}, v = 2)
    static final class C00061 extends ContinuationImpl {
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

        C00061(Continuation<? super C00061> continuation) {
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

    /* JADX WARN: Code duplicated, block: B:150:0x06e9 A[Catch: Exception -> 0x0838, TryCatch #5 {Exception -> 0x0838, blocks: (B:148:0x06e3, B:150:0x06e9, B:153:0x06ff, B:160:0x0718, B:167:0x0751), top: B:309:0x06e3 }] */
    /* JADX WARN: Code duplicated, block: B:153:0x06ff A[Catch: Exception -> 0x0838, TRY_LEAVE, TryCatch #5 {Exception -> 0x0838, blocks: (B:148:0x06e3, B:150:0x06e9, B:153:0x06ff, B:160:0x0718, B:167:0x0751), top: B:309:0x06e3 }] */
    /* JADX WARN: Code duplicated, block: B:155:0x0707  */
    /* JADX WARN: Code duplicated, block: B:165:0x0733  */
    /* JADX WARN: Code duplicated, block: B:340:0x0726 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:7:0x0018  */
    /* JADX WARN: Path cross not found for [B:340:0x0726, B:167:0x0751], limit reached: 379 */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:152:0x06f9 -> B:176:0x0810). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:165:0x0733 -> B:175:0x0807). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:172:0x07bf -> B:350:0x07e6). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:242:0x0b0c -> B:366:0x0b24). Please report as a decompilation issue!!! */
    /*  JADX ERROR: StackOverflowError in pass: RegionMakerVisitor
        java.lang.StackOverflowError
        	at jadx.core.utils.BlockUtils.traverseSuccessorsUntil(BlockUtils.java:731)
        	at jadx.core.utils.BlockUtils.traverseSuccessorsUntil(BlockUtils.java:749)
        */
    static /* synthetic */ java.lang.Object getUrl$suspendImpl(com.allwish.MegaPlay r56, java.lang.String r57, java.lang.String r58, kotlin.jvm.functions.Function1<? super com.lagradost.cloudstream3.SubtitleFile, kotlin.Unit> r59, kotlin.jvm.functions.Function1<? super com.lagradost.cloudstream3.utils.ExtractorLink, kotlin.Unit> r60, kotlin.coroutines.Continuation<? super kotlin.Unit> r61) {
        /*
            Method dump skipped, instruction units count: 3516
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.allwish.MegaPlay.getUrl$suspendImpl(com.allwish.MegaPlay, java.lang.String, java.lang.String, kotlin.jvm.functions.Function1, kotlin.jvm.functions.Function1, kotlin.coroutines.Continuation):java.lang.Object");
    }

    static final Unit getUrl$lambda$3(String result) {
        Log.INSTANCE.d("Megacloud", "JS Result: " + result);
        return Unit.INSTANCE;
    }

    static final Unit getUrl$lambda$4(String result) {
        Log.INSTANCE.d("Megacloud", "Subtitle JS Result: " + result);
        return Unit.INSTANCE;
    }

    /* JADX INFO: compiled from: Extractors.kt */
    @Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\b\u0087\b\u0018\u00002\u00020\u0001B#\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\u000e\b\u0002\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\u0004\b\u0007\u0010\bJ\u000b\u0010\r\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005HÆ\u0003J%\u0010\u000f\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\u000e\b\u0002\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005HÆ\u0001J\u0014\u0010\u0010\u001a\u00020\u00112\b\u0010\u0012\u001a\u0004\u0018\u00010\u0001HÖ\u0083\u0004J\n\u0010\u0013\u001a\u00020\u0014HÖ\u0081\u0004J\n\u0010\u0015\u001a\u00020\u0016HÖ\u0081\u0004R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0017\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fÊ\u0001\u0002\b\u0018¨\u0006\u0017"}, d2 = {"Lcom/allwish/MegaPlay$MegaPlayResponse;", "", "sources", "Lcom/allwish/MegaPlay$Sources;", "tracks", "", "Lcom/allwish/MegaPlay$Track;", "<init>", "(Lcom/allwish/MegaPlay$Sources;Ljava/util/List;)V", "getSources", "()Lcom/allwish/MegaPlay$Sources;", "getTracks", "()Ljava/util/List;", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", "toString", "", "AllWish", "Lkotlinx/serialization/Serializable;"}, k = 1, mv = {2, 4, 0}, xi = 48)
    @Serializable
    public static final /* data */ class MegaPlayResponse {

        @Nullable
        private final Sources sources;

        @NotNull
        private final List<Track> tracks;

        /* JADX WARN: Multi-variable type inference failed */
        public MegaPlayResponse() {
            this(null, 0 == true ? 1 : 0, 3, 0 == true ? 1 : 0);
        }

        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ MegaPlayResponse copy$default(MegaPlayResponse megaPlayResponse, Sources sources, List list, int i, Object obj) {
            if ((i & 1) != 0) {
                sources = megaPlayResponse.sources;
            }
            if ((i & 2) != 0) {
                list = megaPlayResponse.tracks;
            }
            return megaPlayResponse.copy(sources, list);
        }

        @Nullable
        /* JADX INFO: renamed from: component1, reason: from getter */
        public final Sources getSources() {
            return this.sources;
        }

        @NotNull
        public final List<Track> component2() {
            return this.tracks;
        }

        @NotNull
        public final MegaPlayResponse copy(@Nullable Sources sources, @NotNull List<Track> tracks) {
            return new MegaPlayResponse(sources, tracks);
        }

        public boolean equals(@Nullable Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof MegaPlayResponse)) {
                return false;
            }
            MegaPlayResponse megaPlayResponse = (MegaPlayResponse) other;
            return Intrinsics.areEqual(this.sources, megaPlayResponse.sources) && Intrinsics.areEqual(this.tracks, megaPlayResponse.tracks);
        }

        public int hashCode() {
            return ((this.sources == null ? 0 : this.sources.hashCode()) * 31) + this.tracks.hashCode();
        }

        @NotNull
        public String toString() {
            return "MegaPlayResponse(sources=" + this.sources + ", tracks=" + this.tracks + ')';
        }

        public MegaPlayResponse(@Nullable Sources sources, @NotNull List<Track> list) {
            this.sources = sources;
            this.tracks = list;
        }

        public /* synthetic */ MegaPlayResponse(Sources sources, List list, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this((i & 1) != 0 ? null : sources, (i & 2) != 0 ? CollectionsKt.emptyList() : list);
        }

        @Nullable
        public final Sources getSources() {
            return this.sources;
        }

        @NotNull
        public final List<Track> getTracks() {
            return this.tracks;
        }
    }

    /* JADX INFO: compiled from: Extractors.kt */
    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\b\u0087\b\u0018\u00002\u00020\u0001B\u0013\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u000b\u0010\b\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0015\u0010\t\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\u0014\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\u0001HÖ\u0083\u0004J\n\u0010\r\u001a\u00020\u000eHÖ\u0081\u0004J\n\u0010\u000f\u001a\u00020\u0003HÖ\u0081\u0004R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007Ê\u0001\u0002\b\u0011¨\u0006\u0010"}, d2 = {"Lcom/allwish/MegaPlay$Sources;", "", "file", "", "<init>", "(Ljava/lang/String;)V", "getFile", "()Ljava/lang/String;", "component1", "copy", "equals", "", "other", "hashCode", "", "toString", "AllWish", "Lkotlinx/serialization/Serializable;"}, k = 1, mv = {2, 4, 0}, xi = 48)
    @Serializable
    public static final /* data */ class Sources {

        @Nullable
        private final String file;

        /* JADX WARN: Illegal instructions before constructor call */
        public Sources() {
            String str = null;
            this(str, 1, str);
        }

        public static /* synthetic */ Sources copy$default(Sources sources, String str, int i, Object obj) {
            if ((i & 1) != 0) {
                str = sources.file;
            }
            return sources.copy(str);
        }

        @Nullable
        /* JADX INFO: renamed from: component1, reason: from getter */
        public final String getFile() {
            return this.file;
        }

        @NotNull
        public final Sources copy(@Nullable String file) {
            return new Sources(file);
        }

        public boolean equals(@Nullable Object other) {
            if (this == other) {
                return true;
            }
            return (other instanceof Sources) && Intrinsics.areEqual(this.file, ((Sources) other).file);
        }

        public int hashCode() {
            if (this.file == null) {
                return 0;
            }
            return this.file.hashCode();
        }

        @NotNull
        public String toString() {
            return "Sources(file=" + this.file + ')';
        }

        public Sources(@Nullable String file) {
            this.file = file;
        }

        public /* synthetic */ Sources(String str, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this((i & 1) != 0 ? null : str);
        }

        @Nullable
        public final String getFile() {
            return this.file;
        }
    }

    /* JADX INFO: compiled from: Extractors.kt */
    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\r\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\b\u0087\b\u0018\u00002\u00020\u0001B+\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u0006\u0010\u0007J\u000b\u0010\f\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\r\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u000e\u001a\u0004\u0018\u00010\u0003HÆ\u0003J-\u0010\u000f\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\u0014\u0010\u0010\u001a\u00020\u00112\b\u0010\u0012\u001a\u0004\u0018\u00010\u0001HÖ\u0083\u0004J\n\u0010\u0013\u001a\u00020\u0014HÖ\u0081\u0004J\n\u0010\u0015\u001a\u00020\u0003HÖ\u0081\u0004R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\tR\u0013\u0010\u0005\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\tÊ\u0001\u0002\b\u0017¨\u0006\u0016"}, d2 = {"Lcom/allwish/MegaPlay$Track;", "", "file", "", "label", "kind", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getFile", "()Ljava/lang/String;", "getLabel", "getKind", "component1", "component2", "component3", "copy", "equals", "", "other", "hashCode", "", "toString", "AllWish", "Lkotlinx/serialization/Serializable;"}, k = 1, mv = {2, 4, 0}, xi = 48)
    @Serializable
    public static final /* data */ class Track {

        @Nullable
        private final String file;

        @Nullable
        private final String kind;

        @Nullable
        private final String label;

        public Track() {
            this(null, null, null, 7, null);
        }

        public static /* synthetic */ Track copy$default(Track track, String str, String str2, String str3, int i, Object obj) {
            if ((i & 1) != 0) {
                str = track.file;
            }
            if ((i & 2) != 0) {
                str2 = track.label;
            }
            if ((i & 4) != 0) {
                str3 = track.kind;
            }
            return track.copy(str, str2, str3);
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

        @NotNull
        public final Track copy(@Nullable String file, @Nullable String label, @Nullable String kind) {
            return new Track(file, label, kind);
        }

        public boolean equals(@Nullable Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof Track)) {
                return false;
            }
            Track track = (Track) other;
            return Intrinsics.areEqual(this.file, track.file) && Intrinsics.areEqual(this.label, track.label) && Intrinsics.areEqual(this.kind, track.kind);
        }

        public int hashCode() {
            return ((((this.file == null ? 0 : this.file.hashCode()) * 31) + (this.label == null ? 0 : this.label.hashCode())) * 31) + (this.kind != null ? this.kind.hashCode() : 0);
        }

        @NotNull
        public String toString() {
            return "Track(file=" + this.file + ", label=" + this.label + ", kind=" + this.kind + ')';
        }

        public Track(@Nullable String file, @Nullable String label, @Nullable String kind) {
            this.file = file;
            this.label = label;
            this.kind = kind;
        }

        public /* synthetic */ Track(String str, String str2, String str3, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this((i & 1) != 0 ? null : str, (i & 2) != 0 ? null : str2, (i & 4) != 0 ? null : str3);
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
    }
}
