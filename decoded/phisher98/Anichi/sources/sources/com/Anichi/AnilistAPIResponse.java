package com.Anichi;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.lagradost.cloudstream3.syncproviders.providers.AniListApi;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: AnichiUtils.kt */
/* JADX INFO: loaded from: /home/ubuntu/work/NepaliStream-CNC-Repo/decoded/phisher98/Anichi/classes.dex */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\b\u0086\b\u0018\u00002\u00020\u0001:\u0003\u0013\u0014\u0015B\u001f\u0012\u0016\b\u0001\u0010\u0002\u001a\u00020\u0003:\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u0002¢\u0006\u0004\b\u0006\u0010\u0007J\t\u0010\n\u001a\u00020\u0003HÆ\u0003J!\u0010\u000b\u001a\u00020\u00002\u0016\b\u0003\u0010\u0002\u001a\u00020\u0003:\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u0002HÆ\u0001J\u0014\u0010\f\u001a\u00020\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u0001HÖ\u0083\u0004J\n\u0010\u000f\u001a\u00020\u0010HÖ\u0081\u0004J\n\u0010\u0011\u001a\u00020\u0012HÖ\u0081\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\t¨\u0006\u0016"}, d2 = {"Lcom/Anichi/AnilistAPIResponse;", "", "data", "Lcom/Anichi/AnilistAPIResponse$AnilistData;", "Lcom/fasterxml/jackson/annotation/JsonProperty;", "value", "<init>", "(Lcom/Anichi/AnilistAPIResponse$AnilistData;)V", "getData", "()Lcom/Anichi/AnilistAPIResponse$AnilistData;", "component1", "copy", "equals", "", "other", "hashCode", "", "toString", "", "AnilistData", "anilistMedia", "Media", "Anichi"}, k = 1, mv = {2, 4, 0}, xi = 48)
public final /* data */ class AnilistAPIResponse {

    @NotNull
    private final AnilistData data;

    public static /* synthetic */ AnilistAPIResponse copy$default(AnilistAPIResponse anilistAPIResponse, AnilistData anilistData, int i, Object obj) {
        if ((i & 1) != 0) {
            anilistData = anilistAPIResponse.data;
        }
        return anilistAPIResponse.copy(anilistData);
    }

    @NotNull
    /* JADX INFO: renamed from: component1, reason: from getter */
    public final AnilistData getData() {
        return this.data;
    }

    @NotNull
    public final AnilistAPIResponse copy(@JsonProperty("data") @NotNull AnilistData data) {
        return new AnilistAPIResponse(data);
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        return (other instanceof AnilistAPIResponse) && Intrinsics.areEqual(this.data, ((AnilistAPIResponse) other).data);
    }

    public int hashCode() {
        return this.data.hashCode();
    }

    @NotNull
    public String toString() {
        return "AnilistAPIResponse(data=" + this.data + ')';
    }

    public AnilistAPIResponse(@JsonProperty("data") @NotNull AnilistData data) {
        this.data = data;
    }

    @NotNull
    public final AnilistData getData() {
        return this.data;
    }

    /* JADX INFO: compiled from: AnichiUtils.kt */
    @Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001:\u0001\u001aB;\u0012\u0018\b\u0001\u0010\u0002\u001a\u0004\u0018\u00010\u0003:\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u0006\u0012\u0018\b\u0001\u0010\u0007\u001a\u0004\u0018\u00010\b:\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\t¢\u0006\u0004\b\n\u0010\u000bJ\u000b\u0010\u0010\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0011\u001a\u0004\u0018\u00010\bHÆ\u0003J=\u0010\u0012\u001a\u00020\u00002\u0018\b\u0003\u0010\u0002\u001a\u0004\u0018\u00010\u0003:\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u00062\u0018\b\u0003\u0010\u0007\u001a\u0004\u0018\u00010\b:\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\tHÆ\u0001J\u0014\u0010\u0013\u001a\u00020\u00142\b\u0010\u0015\u001a\u0004\u0018\u00010\u0001HÖ\u0083\u0004J\n\u0010\u0016\u001a\u00020\u0017HÖ\u0081\u0004J\n\u0010\u0018\u001a\u00020\u0019HÖ\u0081\u0004R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0013\u0010\u0007\u001a\u0004\u0018\u00010\b¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000f¨\u0006\u001b"}, d2 = {"Lcom/Anichi/AnilistAPIResponse$AnilistData;", "", "page", "Lcom/Anichi/AnilistAPIResponse$AnilistData$AnilistPage;", "Lcom/fasterxml/jackson/annotation/JsonProperty;", "value", "Page", "media", "Lcom/Anichi/AnilistAPIResponse$anilistMedia;", "Media", "<init>", "(Lcom/Anichi/AnilistAPIResponse$AnilistData$AnilistPage;Lcom/Anichi/AnilistAPIResponse$anilistMedia;)V", "getPage", "()Lcom/Anichi/AnilistAPIResponse$AnilistData$AnilistPage;", "getMedia", "()Lcom/Anichi/AnilistAPIResponse$anilistMedia;", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", "toString", "", "AnilistPage", "Anichi"}, k = 1, mv = {2, 4, 0}, xi = 48)
    public static final /* data */ class AnilistData {

        @Nullable
        private final anilistMedia media;

        @Nullable
        private final AnilistPage page;

        public static /* synthetic */ AnilistData copy$default(AnilistData anilistData, AnilistPage anilistPage, anilistMedia anilistmedia, int i, Object obj) {
            if ((i & 1) != 0) {
                anilistPage = anilistData.page;
            }
            if ((i & 2) != 0) {
                anilistmedia = anilistData.media;
            }
            return anilistData.copy(anilistPage, anilistmedia);
        }

        @Nullable
        /* JADX INFO: renamed from: component1, reason: from getter */
        public final AnilistPage getPage() {
            return this.page;
        }

        @Nullable
        /* JADX INFO: renamed from: component2, reason: from getter */
        public final anilistMedia getMedia() {
            return this.media;
        }

        @NotNull
        public final AnilistData copy(@JsonProperty("Page") @Nullable AnilistPage page, @JsonProperty("Media") @Nullable anilistMedia media) {
            return new AnilistData(page, media);
        }

        public boolean equals(@Nullable Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof AnilistData)) {
                return false;
            }
            AnilistData anilistData = (AnilistData) other;
            return Intrinsics.areEqual(this.page, anilistData.page) && Intrinsics.areEqual(this.media, anilistData.media);
        }

        public int hashCode() {
            return ((this.page == null ? 0 : this.page.hashCode()) * 31) + (this.media != null ? this.media.hashCode() : 0);
        }

        @NotNull
        public String toString() {
            return "AnilistData(page=" + this.page + ", media=" + this.media + ')';
        }

        public AnilistData(@JsonProperty("Page") @Nullable AnilistPage page, @JsonProperty("Media") @Nullable anilistMedia media) {
            this.page = page;
            this.media = media;
        }

        @Nullable
        public final AnilistPage getPage() {
            return this.page;
        }

        @Nullable
        public final anilistMedia getMedia() {
            return this.media;
        }

        /* JADX INFO: compiled from: AnichiUtils.kt */
        @Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B=\u0012\u0016\b\u0001\u0010\u0002\u001a\u00020\u0003:\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u0002\u0012\u001c\b\u0001\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007:\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u0006¢\u0006\u0004\b\t\u0010\nJ\t\u0010\u000f\u001a\u00020\u0003HÆ\u0003J\u000f\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\b0\u0007HÆ\u0003J?\u0010\u0011\u001a\u00020\u00002\u0016\b\u0003\u0010\u0002\u001a\u00020\u0003:\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u00022\u001c\b\u0003\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007:\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u0006HÆ\u0001J\u0014\u0010\u0012\u001a\u00020\u00132\b\u0010\u0014\u001a\u0004\u0018\u00010\u0001HÖ\u0083\u0004J\n\u0010\u0015\u001a\u00020\u0016HÖ\u0081\u0004J\n\u0010\u0017\u001a\u00020\u0018HÖ\u0081\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0017\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000e¨\u0006\u0019"}, d2 = {"Lcom/Anichi/AnilistAPIResponse$AnilistData$AnilistPage;", "", "pageInfo", "Lcom/lagradost/cloudstream3/syncproviders/providers/AniListApi$LikePageInfo;", "Lcom/fasterxml/jackson/annotation/JsonProperty;", "value", "media", "", "Lcom/Anichi/AnilistAPIResponse$Media;", "<init>", "(Lcom/lagradost/cloudstream3/syncproviders/providers/AniListApi$LikePageInfo;Ljava/util/List;)V", "getPageInfo", "()Lcom/lagradost/cloudstream3/syncproviders/providers/AniListApi$LikePageInfo;", "getMedia", "()Ljava/util/List;", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", "toString", "", "Anichi"}, k = 1, mv = {2, 4, 0}, xi = 48)
        public static final /* data */ class AnilistPage {

            @NotNull
            private final List<Media> media;

            @NotNull
            private final AniListApi.LikePageInfo pageInfo;

            /* JADX WARN: Multi-variable type inference failed */
            public static /* synthetic */ AnilistPage copy$default(AnilistPage anilistPage, AniListApi.LikePageInfo likePageInfo, List list, int i, Object obj) {
                if ((i & 1) != 0) {
                    likePageInfo = anilistPage.pageInfo;
                }
                if ((i & 2) != 0) {
                    list = anilistPage.media;
                }
                return anilistPage.copy(likePageInfo, list);
            }

            @NotNull
            /* JADX INFO: renamed from: component1, reason: from getter */
            public final AniListApi.LikePageInfo getPageInfo() {
                return this.pageInfo;
            }

            @NotNull
            public final List<Media> component2() {
                return this.media;
            }

            @NotNull
            public final AnilistPage copy(@JsonProperty("pageInfo") @NotNull AniListApi.LikePageInfo pageInfo, @JsonProperty("media") @NotNull List<Media> media) {
                return new AnilistPage(pageInfo, media);
            }

            public boolean equals(@Nullable Object other) {
                if (this == other) {
                    return true;
                }
                if (!(other instanceof AnilistPage)) {
                    return false;
                }
                AnilistPage anilistPage = (AnilistPage) other;
                return Intrinsics.areEqual(this.pageInfo, anilistPage.pageInfo) && Intrinsics.areEqual(this.media, anilistPage.media);
            }

            public int hashCode() {
                return (this.pageInfo.hashCode() * 31) + this.media.hashCode();
            }

            @NotNull
            public String toString() {
                return "AnilistPage(pageInfo=" + this.pageInfo + ", media=" + this.media + ')';
            }

            public AnilistPage(@JsonProperty("pageInfo") @NotNull AniListApi.LikePageInfo pageInfo, @JsonProperty("media") @NotNull List<Media> list) {
                this.pageInfo = pageInfo;
                this.media = list;
            }

            @NotNull
            public final AniListApi.LikePageInfo getPageInfo() {
                return this.pageInfo;
            }

            @NotNull
            public final List<Media> getMedia() {
                return this.media;
            }
        }
    }

    /* JADX INFO: compiled from: AnichiUtils.kt */
    @Metadata(d1 = {"\u0000V\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b/\n\u0002\u0010\u000b\n\u0002\b\u0006\b\u0086\b\u0018\u00002\u00020\u0001:\u0002NOB\u0085\u0003\u0012\u0016\b\u0001\u0010\u0002\u001a\u00020\u0003:\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u0002\u0012\u0016\b\u0001\u0010\u0006\u001a\u00020\u0007:\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u0006\u0012\u0018\b\u0001\u0010\b\u001a\u0004\u0018\u00010\u0003:\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\b\u0012\u0016\b\u0001\u0010\t\u001a\u00020\n:\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\t\u0012\u0018\b\u0001\u0010\u000b\u001a\u0004\u0018\u00010\f:\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u000b\u0012\u001c\b\u0001\u0010\r\u001a\b\u0012\u0004\u0012\u00020\f0\u000e:\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\r\u0012\u0016\b\u0001\u0010\u000f\u001a\u00020\u0003:\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u000f\u0012\u0016\b\u0001\u0010\u0010\u001a\u00020\f:\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u0010\u0012\u0018\b\u0001\u0010\u0011\u001a\u0004\u0018\u00010\f:\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u0011\u0012\u0016\b\u0001\u0010\u0012\u001a\u00020\u0013:\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u0012\u0012\u0018\b\u0001\u0010\u0014\u001a\u0004\u0018\u00010\f:\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u0014\u0012\u0018\b\u0001\u0010\u0015\u001a\u0004\u0018\u00010\u0016:\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u0015\u0012\u0018\b\u0001\u0010\u0017\u001a\u0004\u0018\u00010\u0018:\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u0017\u0012\u0018\b\u0001\u0010\u0019\u001a\u0004\u0018\u00010\u001a:\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u0019\u0012\u0018\b\u0001\u0010\u001b\u001a\u0004\u0018\u00010\f:\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u001b¢\u0006\u0004\b\u001c\u0010\u001dJ\t\u00108\u001a\u00020\u0003HÆ\u0003J\t\u00109\u001a\u00020\u0007HÆ\u0003J\u0010\u0010:\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010#J\t\u0010;\u001a\u00020\nHÆ\u0003J\u000b\u0010<\u001a\u0004\u0018\u00010\fHÆ\u0003J\u000f\u0010=\u001a\b\u0012\u0004\u0012\u00020\f0\u000eHÆ\u0003J\t\u0010>\u001a\u00020\u0003HÆ\u0003J\t\u0010?\u001a\u00020\fHÆ\u0003J\u000b\u0010@\u001a\u0004\u0018\u00010\fHÆ\u0003J\t\u0010A\u001a\u00020\u0013HÆ\u0003J\u000b\u0010B\u001a\u0004\u0018\u00010\fHÆ\u0003J\u000b\u0010C\u001a\u0004\u0018\u00010\u0016HÆ\u0003J\u000b\u0010D\u001a\u0004\u0018\u00010\u0018HÆ\u0003J\u000b\u0010E\u001a\u0004\u0018\u00010\u001aHÆ\u0003J\u000b\u0010F\u001a\u0004\u0018\u00010\fHÆ\u0003J\u008c\u0003\u0010G\u001a\u00020\u00002\u0016\b\u0003\u0010\u0002\u001a\u00020\u0003:\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u00022\u0016\b\u0003\u0010\u0006\u001a\u00020\u0007:\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u00062\u0018\b\u0003\u0010\b\u001a\u0004\u0018\u00010\u0003:\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\b2\u0016\b\u0003\u0010\t\u001a\u00020\n:\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\t2\u0018\b\u0003\u0010\u000b\u001a\u0004\u0018\u00010\f:\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u000b2\u001c\b\u0003\u0010\r\u001a\b\u0012\u0004\u0012\u00020\f0\u000e:\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\r2\u0016\b\u0003\u0010\u000f\u001a\u00020\u0003:\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u000f2\u0016\b\u0003\u0010\u0010\u001a\u00020\f:\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u00102\u0018\b\u0003\u0010\u0011\u001a\u0004\u0018\u00010\f:\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u00112\u0016\b\u0003\u0010\u0012\u001a\u00020\u0013:\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u00122\u0018\b\u0003\u0010\u0014\u001a\u0004\u0018\u00010\f:\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u00142\u0018\b\u0003\u0010\u0015\u001a\u0004\u0018\u00010\u0016:\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u00152\u0018\b\u0003\u0010\u0017\u001a\u0004\u0018\u00010\u0018:\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u00172\u0018\b\u0003\u0010\u0019\u001a\u0004\u0018\u00010\u001a:\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u00192\u0018\b\u0003\u0010\u001b\u001a\u0004\u0018\u00010\f:\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u001bHÆ\u0001¢\u0006\u0002\u0010HJ\u0014\u0010I\u001a\u00020J2\b\u0010K\u001a\u0004\u0018\u00010\u0001HÖ\u0083\u0004J\n\u0010L\u001a\u00020\u0003HÖ\u0081\u0004J\n\u0010M\u001a\u00020\fHÖ\u0081\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\u001fR\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b \u0010!R\u0015\u0010\b\u001a\u0004\u0018\u00010\u0003¢\u0006\n\n\u0002\u0010$\u001a\u0004\b\"\u0010#R\u0011\u0010\t\u001a\u00020\n¢\u0006\b\n\u0000\u001a\u0004\b%\u0010&R\u0013\u0010\u000b\u001a\u0004\u0018\u00010\f¢\u0006\b\n\u0000\u001a\u0004\b'\u0010(R\u0017\u0010\r\u001a\b\u0012\u0004\u0012\u00020\f0\u000e¢\u0006\b\n\u0000\u001a\u0004\b)\u0010*R\u0011\u0010\u000f\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b+\u0010\u001fR\u0011\u0010\u0010\u001a\u00020\f¢\u0006\b\n\u0000\u001a\u0004\b,\u0010(R\u0013\u0010\u0011\u001a\u0004\u0018\u00010\f¢\u0006\b\n\u0000\u001a\u0004\b-\u0010(R\u0011\u0010\u0012\u001a\u00020\u0013¢\u0006\b\n\u0000\u001a\u0004\b.\u0010/R\u0013\u0010\u0014\u001a\u0004\u0018\u00010\f¢\u0006\b\n\u0000\u001a\u0004\b0\u0010(R\u0013\u0010\u0015\u001a\u0004\u0018\u00010\u0016¢\u0006\b\n\u0000\u001a\u0004\b1\u00102R\u0013\u0010\u0017\u001a\u0004\u0018\u00010\u0018¢\u0006\b\n\u0000\u001a\u0004\b3\u00104R\u0013\u0010\u0019\u001a\u0004\u0018\u00010\u001a¢\u0006\b\n\u0000\u001a\u0004\b5\u00106R\u0013\u0010\u001b\u001a\u0004\u0018\u00010\f¢\u0006\b\n\u0000\u001a\u0004\b7\u0010(¨\u0006P"}, d2 = {"Lcom/Anichi/AnilistAPIResponse$anilistMedia;", "", "id", "", "Lcom/fasterxml/jackson/annotation/JsonProperty;", "value", "startDate", "Lcom/Anichi/AnilistAPIResponse$anilistMedia$StartDate;", "episodes", "title", "Lcom/lagradost/cloudstream3/syncproviders/providers/AniListApi$Title;", "season", "", "genres", "", "averageScore", "status", "description", "coverImage", "Lcom/lagradost/cloudstream3/syncproviders/providers/AniListApi$CoverImage;", "bannerImage", "nextAiringEpisode", "Lcom/lagradost/cloudstream3/syncproviders/providers/AniListApi$SeasonNextAiringEpisode;", "airingSchedule", "Lcom/Anichi/AnilistAPIResponse$anilistMedia$AiringScheduleNodes;", "recommendations", "Lcom/lagradost/cloudstream3/syncproviders/providers/AniListApi$RecommendationConnection;", "format", "<init>", "(ILcom/Anichi/AnilistAPIResponse$anilistMedia$StartDate;Ljava/lang/Integer;Lcom/lagradost/cloudstream3/syncproviders/providers/AniListApi$Title;Ljava/lang/String;Ljava/util/List;ILjava/lang/String;Ljava/lang/String;Lcom/lagradost/cloudstream3/syncproviders/providers/AniListApi$CoverImage;Ljava/lang/String;Lcom/lagradost/cloudstream3/syncproviders/providers/AniListApi$SeasonNextAiringEpisode;Lcom/Anichi/AnilistAPIResponse$anilistMedia$AiringScheduleNodes;Lcom/lagradost/cloudstream3/syncproviders/providers/AniListApi$RecommendationConnection;Ljava/lang/String;)V", "getId", "()I", "getStartDate", "()Lcom/Anichi/AnilistAPIResponse$anilistMedia$StartDate;", "getEpisodes", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "getTitle", "()Lcom/lagradost/cloudstream3/syncproviders/providers/AniListApi$Title;", "getSeason", "()Ljava/lang/String;", "getGenres", "()Ljava/util/List;", "getAverageScore", "getStatus", "getDescription", "getCoverImage", "()Lcom/lagradost/cloudstream3/syncproviders/providers/AniListApi$CoverImage;", "getBannerImage", "getNextAiringEpisode", "()Lcom/lagradost/cloudstream3/syncproviders/providers/AniListApi$SeasonNextAiringEpisode;", "getAiringSchedule", "()Lcom/Anichi/AnilistAPIResponse$anilistMedia$AiringScheduleNodes;", "getRecommendations", "()Lcom/lagradost/cloudstream3/syncproviders/providers/AniListApi$RecommendationConnection;", "getFormat", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "component10", "component11", "component12", "component13", "component14", "component15", "copy", "(ILcom/Anichi/AnilistAPIResponse$anilistMedia$StartDate;Ljava/lang/Integer;Lcom/lagradost/cloudstream3/syncproviders/providers/AniListApi$Title;Ljava/lang/String;Ljava/util/List;ILjava/lang/String;Ljava/lang/String;Lcom/lagradost/cloudstream3/syncproviders/providers/AniListApi$CoverImage;Ljava/lang/String;Lcom/lagradost/cloudstream3/syncproviders/providers/AniListApi$SeasonNextAiringEpisode;Lcom/Anichi/AnilistAPIResponse$anilistMedia$AiringScheduleNodes;Lcom/lagradost/cloudstream3/syncproviders/providers/AniListApi$RecommendationConnection;Ljava/lang/String;)Lcom/Anichi/AnilistAPIResponse$anilistMedia;", "equals", "", "other", "hashCode", "toString", "StartDate", "AiringScheduleNodes", "Anichi"}, k = 1, mv = {2, 4, 0}, xi = 48)
    public static final /* data */ class anilistMedia {

        @Nullable
        private final AiringScheduleNodes airingSchedule;
        private final int averageScore;

        @Nullable
        private final String bannerImage;

        @NotNull
        private final AniListApi.CoverImage coverImage;

        @Nullable
        private final String description;

        @Nullable
        private final Integer episodes;

        @Nullable
        private final String format;

        @NotNull
        private final List<String> genres;
        private final int id;

        @Nullable
        private final AniListApi.SeasonNextAiringEpisode nextAiringEpisode;

        @Nullable
        private final AniListApi.RecommendationConnection recommendations;

        @Nullable
        private final String season;

        @NotNull
        private final StartDate startDate;

        @NotNull
        private final String status;

        @NotNull
        private final AniListApi.Title title;

        /* JADX INFO: renamed from: component1, reason: from getter */
        public final int getId() {
            return this.id;
        }

        @NotNull
        /* JADX INFO: renamed from: component10, reason: from getter */
        public final AniListApi.CoverImage getCoverImage() {
            return this.coverImage;
        }

        @Nullable
        /* JADX INFO: renamed from: component11, reason: from getter */
        public final String getBannerImage() {
            return this.bannerImage;
        }

        @Nullable
        /* JADX INFO: renamed from: component12, reason: from getter */
        public final AniListApi.SeasonNextAiringEpisode getNextAiringEpisode() {
            return this.nextAiringEpisode;
        }

        @Nullable
        /* JADX INFO: renamed from: component13, reason: from getter */
        public final AiringScheduleNodes getAiringSchedule() {
            return this.airingSchedule;
        }

        @Nullable
        /* JADX INFO: renamed from: component14, reason: from getter */
        public final AniListApi.RecommendationConnection getRecommendations() {
            return this.recommendations;
        }

        @Nullable
        /* JADX INFO: renamed from: component15, reason: from getter */
        public final String getFormat() {
            return this.format;
        }

        @NotNull
        /* JADX INFO: renamed from: component2, reason: from getter */
        public final StartDate getStartDate() {
            return this.startDate;
        }

        @Nullable
        /* JADX INFO: renamed from: component3, reason: from getter */
        public final Integer getEpisodes() {
            return this.episodes;
        }

        @NotNull
        /* JADX INFO: renamed from: component4, reason: from getter */
        public final AniListApi.Title getTitle() {
            return this.title;
        }

        @Nullable
        /* JADX INFO: renamed from: component5, reason: from getter */
        public final String getSeason() {
            return this.season;
        }

        @NotNull
        public final List<String> component6() {
            return this.genres;
        }

        /* JADX INFO: renamed from: component7, reason: from getter */
        public final int getAverageScore() {
            return this.averageScore;
        }

        @NotNull
        /* JADX INFO: renamed from: component8, reason: from getter */
        public final String getStatus() {
            return this.status;
        }

        @Nullable
        /* JADX INFO: renamed from: component9, reason: from getter */
        public final String getDescription() {
            return this.description;
        }

        @NotNull
        public final anilistMedia copy(@JsonProperty("id") int id, @JsonProperty("startDate") @NotNull StartDate startDate, @JsonProperty("episodes") @Nullable Integer episodes, @JsonProperty("title") @NotNull AniListApi.Title title, @JsonProperty("season") @Nullable String season, @JsonProperty("genres") @NotNull List<String> genres, @JsonProperty("averageScore") int averageScore, @JsonProperty("status") @NotNull String status, @JsonProperty("description") @Nullable String description, @JsonProperty("coverImage") @NotNull AniListApi.CoverImage coverImage, @JsonProperty("bannerImage") @Nullable String bannerImage, @JsonProperty("nextAiringEpisode") @Nullable AniListApi.SeasonNextAiringEpisode nextAiringEpisode, @JsonProperty("airingSchedule") @Nullable AiringScheduleNodes airingSchedule, @JsonProperty("recommendations") @Nullable AniListApi.RecommendationConnection recommendations, @JsonProperty("format") @Nullable String format) {
            return new anilistMedia(id, startDate, episodes, title, season, genres, averageScore, status, description, coverImage, bannerImage, nextAiringEpisode, airingSchedule, recommendations, format);
        }

        public boolean equals(@Nullable Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof anilistMedia)) {
                return false;
            }
            anilistMedia anilistmedia = (anilistMedia) other;
            return this.id == anilistmedia.id && Intrinsics.areEqual(this.startDate, anilistmedia.startDate) && Intrinsics.areEqual(this.episodes, anilistmedia.episodes) && Intrinsics.areEqual(this.title, anilistmedia.title) && Intrinsics.areEqual(this.season, anilistmedia.season) && Intrinsics.areEqual(this.genres, anilistmedia.genres) && this.averageScore == anilistmedia.averageScore && Intrinsics.areEqual(this.status, anilistmedia.status) && Intrinsics.areEqual(this.description, anilistmedia.description) && Intrinsics.areEqual(this.coverImage, anilistmedia.coverImage) && Intrinsics.areEqual(this.bannerImage, anilistmedia.bannerImage) && Intrinsics.areEqual(this.nextAiringEpisode, anilistmedia.nextAiringEpisode) && Intrinsics.areEqual(this.airingSchedule, anilistmedia.airingSchedule) && Intrinsics.areEqual(this.recommendations, anilistmedia.recommendations) && Intrinsics.areEqual(this.format, anilistmedia.format);
        }

        public int hashCode() {
            return (((((((((((((((((((((((((((this.id * 31) + this.startDate.hashCode()) * 31) + (this.episodes == null ? 0 : this.episodes.hashCode())) * 31) + this.title.hashCode()) * 31) + (this.season == null ? 0 : this.season.hashCode())) * 31) + this.genres.hashCode()) * 31) + this.averageScore) * 31) + this.status.hashCode()) * 31) + (this.description == null ? 0 : this.description.hashCode())) * 31) + this.coverImage.hashCode()) * 31) + (this.bannerImage == null ? 0 : this.bannerImage.hashCode())) * 31) + (this.nextAiringEpisode == null ? 0 : this.nextAiringEpisode.hashCode())) * 31) + (this.airingSchedule == null ? 0 : this.airingSchedule.hashCode())) * 31) + (this.recommendations == null ? 0 : this.recommendations.hashCode())) * 31) + (this.format != null ? this.format.hashCode() : 0);
        }

        @NotNull
        public String toString() {
            StringBuilder sb = new StringBuilder();
            sb.append("anilistMedia(id=").append(this.id).append(", startDate=").append(this.startDate).append(", episodes=").append(this.episodes).append(", title=").append(this.title).append(", season=").append(this.season).append(", genres=").append(this.genres).append(", averageScore=").append(this.averageScore).append(", status=").append(this.status).append(", description=").append(this.description).append(", coverImage=").append(this.coverImage).append(", bannerImage=").append(this.bannerImage).append(", nextAiringEpisode=");
            sb.append(this.nextAiringEpisode).append(", airingSchedule=").append(this.airingSchedule).append(", recommendations=").append(this.recommendations).append(", format=").append(this.format).append(')');
            return sb.toString();
        }

        public anilistMedia(@JsonProperty("id") int id, @JsonProperty("startDate") @NotNull StartDate startDate, @JsonProperty("episodes") @Nullable Integer episodes, @JsonProperty("title") @NotNull AniListApi.Title title, @JsonProperty("season") @Nullable String season, @JsonProperty("genres") @NotNull List<String> list, @JsonProperty("averageScore") int averageScore, @JsonProperty("status") @NotNull String status, @JsonProperty("description") @Nullable String description, @JsonProperty("coverImage") @NotNull AniListApi.CoverImage coverImage, @JsonProperty("bannerImage") @Nullable String bannerImage, @JsonProperty("nextAiringEpisode") @Nullable AniListApi.SeasonNextAiringEpisode nextAiringEpisode, @JsonProperty("airingSchedule") @Nullable AiringScheduleNodes airingSchedule, @JsonProperty("recommendations") @Nullable AniListApi.RecommendationConnection recommendations, @JsonProperty("format") @Nullable String format) {
            this.id = id;
            this.startDate = startDate;
            this.episodes = episodes;
            this.title = title;
            this.season = season;
            this.genres = list;
            this.averageScore = averageScore;
            this.status = status;
            this.description = description;
            this.coverImage = coverImage;
            this.bannerImage = bannerImage;
            this.nextAiringEpisode = nextAiringEpisode;
            this.airingSchedule = airingSchedule;
            this.recommendations = recommendations;
            this.format = format;
        }

        public final int getId() {
            return this.id;
        }

        @NotNull
        public final StartDate getStartDate() {
            return this.startDate;
        }

        @Nullable
        public final Integer getEpisodes() {
            return this.episodes;
        }

        @NotNull
        public final AniListApi.Title getTitle() {
            return this.title;
        }

        @Nullable
        public final String getSeason() {
            return this.season;
        }

        @NotNull
        public final List<String> getGenres() {
            return this.genres;
        }

        public final int getAverageScore() {
            return this.averageScore;
        }

        @NotNull
        public final String getStatus() {
            return this.status;
        }

        @Nullable
        public final String getDescription() {
            return this.description;
        }

        @NotNull
        public final AniListApi.CoverImage getCoverImage() {
            return this.coverImage;
        }

        @Nullable
        public final String getBannerImage() {
            return this.bannerImage;
        }

        @Nullable
        public final AniListApi.SeasonNextAiringEpisode getNextAiringEpisode() {
            return this.nextAiringEpisode;
        }

        @Nullable
        public final AiringScheduleNodes getAiringSchedule() {
            return this.airingSchedule;
        }

        @Nullable
        public final AniListApi.RecommendationConnection getRecommendations() {
            return this.recommendations;
        }

        @Nullable
        public final String getFormat() {
            return this.format;
        }

        /* JADX INFO: compiled from: AnichiUtils.kt */
        @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\u001f\u0012\u0016\b\u0001\u0010\u0002\u001a\u00020\u0003:\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u0002¢\u0006\u0004\b\u0006\u0010\u0007J\t\u0010\n\u001a\u00020\u0003HÆ\u0003J!\u0010\u000b\u001a\u00020\u00002\u0016\b\u0003\u0010\u0002\u001a\u00020\u0003:\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u0002HÆ\u0001J\u0014\u0010\f\u001a\u00020\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u0001HÖ\u0083\u0004J\n\u0010\u000f\u001a\u00020\u0003HÖ\u0081\u0004J\n\u0010\u0010\u001a\u00020\u0011HÖ\u0081\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\t¨\u0006\u0012"}, d2 = {"Lcom/Anichi/AnilistAPIResponse$anilistMedia$StartDate;", "", "year", "", "Lcom/fasterxml/jackson/annotation/JsonProperty;", "value", "<init>", "(I)V", "getYear", "()I", "component1", "copy", "equals", "", "other", "hashCode", "toString", "", "Anichi"}, k = 1, mv = {2, 4, 0}, xi = 48)
        public static final /* data */ class StartDate {
            private final int year;

            public static /* synthetic */ StartDate copy$default(StartDate startDate, int i, int i2, Object obj) {
                if ((i2 & 1) != 0) {
                    i = startDate.year;
                }
                return startDate.copy(i);
            }

            /* JADX INFO: renamed from: component1, reason: from getter */
            public final int getYear() {
                return this.year;
            }

            @NotNull
            public final StartDate copy(@JsonProperty("year") int year) {
                return new StartDate(year);
            }

            public boolean equals(@Nullable Object other) {
                if (this == other) {
                    return true;
                }
                return (other instanceof StartDate) && this.year == ((StartDate) other).year;
            }

            public int hashCode() {
                return this.year;
            }

            @NotNull
            public String toString() {
                return "StartDate(year=" + this.year + ')';
            }

            public StartDate(@JsonProperty("year") int year) {
                this.year = year;
            }

            public final int getYear() {
                return this.year;
            }
        }

        /* JADX INFO: compiled from: AnichiUtils.kt */
        @Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B'\u0012\u001e\b\u0001\u0010\u0002\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003:\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(\u0002¢\u0006\u0004\b\u0007\u0010\bJ\u0011\u0010\u000b\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003HÆ\u0003J)\u0010\f\u001a\u00020\u00002\u001e\b\u0003\u0010\u0002\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003:\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(\u0002HÆ\u0001J\u0014\u0010\r\u001a\u00020\u000e2\b\u0010\u000f\u001a\u0004\u0018\u00010\u0001HÖ\u0083\u0004J\n\u0010\u0010\u001a\u00020\u0011HÖ\u0081\u0004J\n\u0010\u0012\u001a\u00020\u0013HÖ\u0081\u0004R\u0019\u0010\u0002\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n¨\u0006\u0014"}, d2 = {"Lcom/Anichi/AnilistAPIResponse$anilistMedia$AiringScheduleNodes;", "", "nodes", "", "Lcom/lagradost/cloudstream3/syncproviders/providers/AniListApi$SeasonNextAiringEpisode;", "Lcom/fasterxml/jackson/annotation/JsonProperty;", "value", "<init>", "(Ljava/util/List;)V", "getNodes", "()Ljava/util/List;", "component1", "copy", "equals", "", "other", "hashCode", "", "toString", "", "Anichi"}, k = 1, mv = {2, 4, 0}, xi = 48)
        public static final /* data */ class AiringScheduleNodes {

            @Nullable
            private final List<AniListApi.SeasonNextAiringEpisode> nodes;

            /* JADX WARN: Multi-variable type inference failed */
            public static /* synthetic */ AiringScheduleNodes copy$default(AiringScheduleNodes airingScheduleNodes, List list, int i, Object obj) {
                if ((i & 1) != 0) {
                    list = airingScheduleNodes.nodes;
                }
                return airingScheduleNodes.copy(list);
            }

            @Nullable
            public final List<AniListApi.SeasonNextAiringEpisode> component1() {
                return this.nodes;
            }

            @NotNull
            public final AiringScheduleNodes copy(@JsonProperty("nodes") @Nullable List<AniListApi.SeasonNextAiringEpisode> nodes) {
                return new AiringScheduleNodes(nodes);
            }

            public boolean equals(@Nullable Object other) {
                if (this == other) {
                    return true;
                }
                return (other instanceof AiringScheduleNodes) && Intrinsics.areEqual(this.nodes, ((AiringScheduleNodes) other).nodes);
            }

            public int hashCode() {
                if (this.nodes == null) {
                    return 0;
                }
                return this.nodes.hashCode();
            }

            @NotNull
            public String toString() {
                return "AiringScheduleNodes(nodes=" + this.nodes + ')';
            }

            public AiringScheduleNodes(@JsonProperty("nodes") @Nullable List<AniListApi.SeasonNextAiringEpisode> list) {
                this.nodes = list;
            }

            @Nullable
            public final List<AniListApi.SeasonNextAiringEpisode> getNodes() {
                return this.nodes;
            }
        }
    }

    /* JADX INFO: compiled from: AnichiUtils.kt */
    @Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0000\n\u0002\u0018\u0002\n\u0002\b%\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0086\b\u0018\u00002\u00020\u0001B·\u0002\u0012\u0016\b\u0001\u0010\u0002\u001a\u00020\u0003:\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u0002\u0012\u0018\b\u0001\u0010\u0006\u001a\u0004\u0018\u00010\u0003:\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u0006\u0012\u0018\b\u0001\u0010\u0007\u001a\u0004\u0018\u00010\b:\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u0007\u0012\u0016\b\u0001\u0010\t\u001a\u00020\u0003:\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\t\u0012\u0018\b\u0001\u0010\n\u001a\u0004\u0018\u00010\b:\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\n\u0012\u0016\b\u0001\u0010\u000b\u001a\u00020\u0003:\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u000b\u0012\u0016\b\u0001\u0010\f\u001a\u00020\u0003:\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\f\u0012\u0016\b\u0001\u0010\r\u001a\u00020\u000e:\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\r\u0012\u0018\b\u0001\u0010\u000f\u001a\u0004\u0018\u00010\b:\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u000f\u0012\u0016\b\u0001\u0010\u0010\u001a\u00020\u0011:\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u0010\u0012\u001c\b\u0001\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\b0\u0013:\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u0012\u0012\u0018\b\u0001\u0010\u0014\u001a\u0004\u0018\u00010\u0015:\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u0014¢\u0006\u0004\b\u0016\u0010\u0017J\t\u0010,\u001a\u00020\u0003HÆ\u0003J\u0010\u0010-\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u001bJ\u000b\u0010.\u001a\u0004\u0018\u00010\bHÆ\u0003J\t\u0010/\u001a\u00020\u0003HÆ\u0003J\u000b\u00100\u001a\u0004\u0018\u00010\bHÆ\u0003J\t\u00101\u001a\u00020\u0003HÆ\u0003J\t\u00102\u001a\u00020\u0003HÆ\u0003J\t\u00103\u001a\u00020\u000eHÆ\u0003J\u000b\u00104\u001a\u0004\u0018\u00010\bHÆ\u0003J\t\u00105\u001a\u00020\u0011HÆ\u0003J\u000f\u00106\u001a\b\u0012\u0004\u0012\u00020\b0\u0013HÆ\u0003J\u000b\u00107\u001a\u0004\u0018\u00010\u0015HÆ\u0003J¾\u0002\u00108\u001a\u00020\u00002\u0016\b\u0003\u0010\u0002\u001a\u00020\u0003:\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u00022\u0018\b\u0003\u0010\u0006\u001a\u0004\u0018\u00010\u0003:\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u00062\u0018\b\u0003\u0010\u0007\u001a\u0004\u0018\u00010\b:\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u00072\u0016\b\u0003\u0010\t\u001a\u00020\u0003:\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\t2\u0018\b\u0003\u0010\n\u001a\u0004\u0018\u00010\b:\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\n2\u0016\b\u0003\u0010\u000b\u001a\u00020\u0003:\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u000b2\u0016\b\u0003\u0010\f\u001a\u00020\u0003:\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\f2\u0016\b\u0003\u0010\r\u001a\u00020\u000e:\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\r2\u0018\b\u0003\u0010\u000f\u001a\u0004\u0018\u00010\b:\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u000f2\u0016\b\u0003\u0010\u0010\u001a\u00020\u0011:\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u00102\u001c\b\u0003\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\b0\u0013:\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u00122\u0018\b\u0003\u0010\u0014\u001a\u0004\u0018\u00010\u0015:\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u0014HÆ\u0001¢\u0006\u0002\u00109J\u0014\u0010:\u001a\u00020;2\b\u0010<\u001a\u0004\u0018\u00010\u0001HÖ\u0083\u0004J\n\u0010=\u001a\u00020\u0003HÖ\u0081\u0004J\n\u0010>\u001a\u00020\bHÖ\u0081\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0019R\u0015\u0010\u0006\u001a\u0004\u0018\u00010\u0003¢\u0006\n\n\u0002\u0010\u001c\u001a\u0004\b\u001a\u0010\u001bR\u0013\u0010\u0007\u001a\u0004\u0018\u00010\b¢\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u001eR\u0011\u0010\t\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001f\u0010\u0019R\u0013\u0010\n\u001a\u0004\u0018\u00010\b¢\u0006\b\n\u0000\u001a\u0004\b \u0010\u001eR\u0011\u0010\u000b\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b!\u0010\u0019R\u0011\u0010\f\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\"\u0010\u0019R\u0011\u0010\r\u001a\u00020\u000e¢\u0006\b\n\u0000\u001a\u0004\b#\u0010$R\u0013\u0010\u000f\u001a\u0004\u0018\u00010\b¢\u0006\b\n\u0000\u001a\u0004\b%\u0010\u001eR\u0011\u0010\u0010\u001a\u00020\u0011¢\u0006\b\n\u0000\u001a\u0004\b&\u0010'R\u0017\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\b0\u0013¢\u0006\b\n\u0000\u001a\u0004\b(\u0010)R\u0013\u0010\u0014\u001a\u0004\u0018\u00010\u0015¢\u0006\b\n\u0000\u001a\u0004\b*\u0010+¨\u0006?"}, d2 = {"Lcom/Anichi/AnilistAPIResponse$Media;", "", "id", "", "Lcom/fasterxml/jackson/annotation/JsonProperty;", "value", "idMal", "season", "", "seasonYear", "format", "averageScore", "episodes", "title", "Lcom/lagradost/cloudstream3/syncproviders/providers/AniListApi$Title;", "description", "coverImage", "Lcom/lagradost/cloudstream3/syncproviders/providers/AniListApi$CoverImage;", "synonyms", "", "nextAiringEpisode", "Lcom/lagradost/cloudstream3/syncproviders/providers/AniListApi$SeasonNextAiringEpisode;", "<init>", "(ILjava/lang/Integer;Ljava/lang/String;ILjava/lang/String;IILcom/lagradost/cloudstream3/syncproviders/providers/AniListApi$Title;Ljava/lang/String;Lcom/lagradost/cloudstream3/syncproviders/providers/AniListApi$CoverImage;Ljava/util/List;Lcom/lagradost/cloudstream3/syncproviders/providers/AniListApi$SeasonNextAiringEpisode;)V", "getId", "()I", "getIdMal", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "getSeason", "()Ljava/lang/String;", "getSeasonYear", "getFormat", "getAverageScore", "getEpisodes", "getTitle", "()Lcom/lagradost/cloudstream3/syncproviders/providers/AniListApi$Title;", "getDescription", "getCoverImage", "()Lcom/lagradost/cloudstream3/syncproviders/providers/AniListApi$CoverImage;", "getSynonyms", "()Ljava/util/List;", "getNextAiringEpisode", "()Lcom/lagradost/cloudstream3/syncproviders/providers/AniListApi$SeasonNextAiringEpisode;", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "component10", "component11", "component12", "copy", "(ILjava/lang/Integer;Ljava/lang/String;ILjava/lang/String;IILcom/lagradost/cloudstream3/syncproviders/providers/AniListApi$Title;Ljava/lang/String;Lcom/lagradost/cloudstream3/syncproviders/providers/AniListApi$CoverImage;Ljava/util/List;Lcom/lagradost/cloudstream3/syncproviders/providers/AniListApi$SeasonNextAiringEpisode;)Lcom/Anichi/AnilistAPIResponse$Media;", "equals", "", "other", "hashCode", "toString", "Anichi"}, k = 1, mv = {2, 4, 0}, xi = 48)
    public static final /* data */ class Media {
        private final int averageScore;

        @NotNull
        private final AniListApi.CoverImage coverImage;

        @Nullable
        private final String description;
        private final int episodes;

        @Nullable
        private final String format;
        private final int id;

        @Nullable
        private final Integer idMal;

        @Nullable
        private final AniListApi.SeasonNextAiringEpisode nextAiringEpisode;

        @Nullable
        private final String season;
        private final int seasonYear;

        @NotNull
        private final List<String> synonyms;

        @NotNull
        private final AniListApi.Title title;

        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ Media copy$default(Media media, int i, Integer num, String str, int i2, String str2, int i3, int i4, AniListApi.Title title, String str3, AniListApi.CoverImage coverImage, List list, AniListApi.SeasonNextAiringEpisode seasonNextAiringEpisode, int i5, Object obj) {
            if ((i5 & 1) != 0) {
                i = media.id;
            }
            if ((i5 & 2) != 0) {
                num = media.idMal;
            }
            if ((i5 & 4) != 0) {
                str = media.season;
            }
            if ((i5 & 8) != 0) {
                i2 = media.seasonYear;
            }
            if ((i5 & 16) != 0) {
                str2 = media.format;
            }
            if ((i5 & 32) != 0) {
                i3 = media.averageScore;
            }
            if ((i5 & 64) != 0) {
                i4 = media.episodes;
            }
            if ((i5 & 128) != 0) {
                title = media.title;
            }
            if ((i5 & 256) != 0) {
                str3 = media.description;
            }
            if ((i5 & 512) != 0) {
                coverImage = media.coverImage;
            }
            if ((i5 & 1024) != 0) {
                list = media.synonyms;
            }
            if ((i5 & 2048) != 0) {
                seasonNextAiringEpisode = media.nextAiringEpisode;
            }
            List list2 = list;
            AniListApi.SeasonNextAiringEpisode seasonNextAiringEpisode2 = seasonNextAiringEpisode;
            String str4 = str3;
            AniListApi.CoverImage coverImage2 = coverImage;
            int i6 = i4;
            AniListApi.Title title2 = title;
            String str5 = str2;
            int i7 = i3;
            return media.copy(i, num, str, i2, str5, i7, i6, title2, str4, coverImage2, list2, seasonNextAiringEpisode2);
        }

        /* JADX INFO: renamed from: component1, reason: from getter */
        public final int getId() {
            return this.id;
        }

        @NotNull
        /* JADX INFO: renamed from: component10, reason: from getter */
        public final AniListApi.CoverImage getCoverImage() {
            return this.coverImage;
        }

        @NotNull
        public final List<String> component11() {
            return this.synonyms;
        }

        @Nullable
        /* JADX INFO: renamed from: component12, reason: from getter */
        public final AniListApi.SeasonNextAiringEpisode getNextAiringEpisode() {
            return this.nextAiringEpisode;
        }

        @Nullable
        /* JADX INFO: renamed from: component2, reason: from getter */
        public final Integer getIdMal() {
            return this.idMal;
        }

        @Nullable
        /* JADX INFO: renamed from: component3, reason: from getter */
        public final String getSeason() {
            return this.season;
        }

        /* JADX INFO: renamed from: component4, reason: from getter */
        public final int getSeasonYear() {
            return this.seasonYear;
        }

        @Nullable
        /* JADX INFO: renamed from: component5, reason: from getter */
        public final String getFormat() {
            return this.format;
        }

        /* JADX INFO: renamed from: component6, reason: from getter */
        public final int getAverageScore() {
            return this.averageScore;
        }

        /* JADX INFO: renamed from: component7, reason: from getter */
        public final int getEpisodes() {
            return this.episodes;
        }

        @NotNull
        /* JADX INFO: renamed from: component8, reason: from getter */
        public final AniListApi.Title getTitle() {
            return this.title;
        }

        @Nullable
        /* JADX INFO: renamed from: component9, reason: from getter */
        public final String getDescription() {
            return this.description;
        }

        @NotNull
        public final Media copy(@JsonProperty("id") int id, @JsonProperty("idMal") @Nullable Integer idMal, @JsonProperty("season") @Nullable String season, @JsonProperty("seasonYear") int seasonYear, @JsonProperty("format") @Nullable String format, @JsonProperty("averageScore") int averageScore, @JsonProperty("episodes") int episodes, @JsonProperty("title") @NotNull AniListApi.Title title, @JsonProperty("description") @Nullable String description, @JsonProperty("coverImage") @NotNull AniListApi.CoverImage coverImage, @JsonProperty("synonyms") @NotNull List<String> synonyms, @JsonProperty("nextAiringEpisode") @Nullable AniListApi.SeasonNextAiringEpisode nextAiringEpisode) {
            return new Media(id, idMal, season, seasonYear, format, averageScore, episodes, title, description, coverImage, synonyms, nextAiringEpisode);
        }

        public boolean equals(@Nullable Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof Media)) {
                return false;
            }
            Media media = (Media) other;
            return this.id == media.id && Intrinsics.areEqual(this.idMal, media.idMal) && Intrinsics.areEqual(this.season, media.season) && this.seasonYear == media.seasonYear && Intrinsics.areEqual(this.format, media.format) && this.averageScore == media.averageScore && this.episodes == media.episodes && Intrinsics.areEqual(this.title, media.title) && Intrinsics.areEqual(this.description, media.description) && Intrinsics.areEqual(this.coverImage, media.coverImage) && Intrinsics.areEqual(this.synonyms, media.synonyms) && Intrinsics.areEqual(this.nextAiringEpisode, media.nextAiringEpisode);
        }

        public int hashCode() {
            return (((((((((((((((((((((this.id * 31) + (this.idMal == null ? 0 : this.idMal.hashCode())) * 31) + (this.season == null ? 0 : this.season.hashCode())) * 31) + this.seasonYear) * 31) + (this.format == null ? 0 : this.format.hashCode())) * 31) + this.averageScore) * 31) + this.episodes) * 31) + this.title.hashCode()) * 31) + (this.description == null ? 0 : this.description.hashCode())) * 31) + this.coverImage.hashCode()) * 31) + this.synonyms.hashCode()) * 31) + (this.nextAiringEpisode != null ? this.nextAiringEpisode.hashCode() : 0);
        }

        @NotNull
        public String toString() {
            StringBuilder sb = new StringBuilder();
            sb.append("Media(id=").append(this.id).append(", idMal=").append(this.idMal).append(", season=").append(this.season).append(", seasonYear=").append(this.seasonYear).append(", format=").append(this.format).append(", averageScore=").append(this.averageScore).append(", episodes=").append(this.episodes).append(", title=").append(this.title).append(", description=").append(this.description).append(", coverImage=").append(this.coverImage).append(", synonyms=").append(this.synonyms).append(", nextAiringEpisode=");
            sb.append(this.nextAiringEpisode).append(')');
            return sb.toString();
        }

        public Media(@JsonProperty("id") int id, @JsonProperty("idMal") @Nullable Integer idMal, @JsonProperty("season") @Nullable String season, @JsonProperty("seasonYear") int seasonYear, @JsonProperty("format") @Nullable String format, @JsonProperty("averageScore") int averageScore, @JsonProperty("episodes") int episodes, @JsonProperty("title") @NotNull AniListApi.Title title, @JsonProperty("description") @Nullable String description, @JsonProperty("coverImage") @NotNull AniListApi.CoverImage coverImage, @JsonProperty("synonyms") @NotNull List<String> list, @JsonProperty("nextAiringEpisode") @Nullable AniListApi.SeasonNextAiringEpisode nextAiringEpisode) {
            this.id = id;
            this.idMal = idMal;
            this.season = season;
            this.seasonYear = seasonYear;
            this.format = format;
            this.averageScore = averageScore;
            this.episodes = episodes;
            this.title = title;
            this.description = description;
            this.coverImage = coverImage;
            this.synonyms = list;
            this.nextAiringEpisode = nextAiringEpisode;
        }

        public final int getId() {
            return this.id;
        }

        @Nullable
        public final Integer getIdMal() {
            return this.idMal;
        }

        @Nullable
        public final String getSeason() {
            return this.season;
        }

        public final int getSeasonYear() {
            return this.seasonYear;
        }

        @Nullable
        public final String getFormat() {
            return this.format;
        }

        public final int getAverageScore() {
            return this.averageScore;
        }

        public final int getEpisodes() {
            return this.episodes;
        }

        @NotNull
        public final AniListApi.Title getTitle() {
            return this.title;
        }

        @Nullable
        public final String getDescription() {
            return this.description;
        }

        @NotNull
        public final AniListApi.CoverImage getCoverImage() {
            return this.coverImage;
        }

        @NotNull
        public final List<String> getSynonyms() {
            return this.synonyms;
        }

        @Nullable
        public final AniListApi.SeasonNextAiringEpisode getNextAiringEpisode() {
            return this.nextAiringEpisode;
        }
    }
}
