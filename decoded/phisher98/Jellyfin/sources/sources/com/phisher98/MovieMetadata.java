package com.phisher98;

import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: JellyfinParser.kt */
/* JADX INFO: loaded from: /home/ubuntu/work/NepaliStream-CNC-Repo/decoded/phisher98/Jellyfin/classes.dex */
@Metadata(d1 = {"\u0000b\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0006\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b#\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B¿\u0002\u0012\u001c\b\u0003\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003:\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(\u0007\u0012\u0016\b\u0001\u0010\b\u001a\u00020\t:\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(\n\u0012\u0016\b\u0001\u0010\u000b\u001a\u00020\t:\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(\f\u0012\u0016\b\u0001\u0010\r\u001a\u00020\t:\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(\u000e\u0012\u0016\b\u0001\u0010\u000f\u001a\u00020\u0010:\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(\u0011\u0012\u0016\b\u0001\u0010\u0012\u001a\u00020\u0013:\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(\u0014\u0012\u001c\b\u0001\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00160\u0003:\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(\u0017\u0012\u0016\b\u0001\u0010\u0018\u001a\u00020\u0019:\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(\u001a\u0012\u001c\b\u0001\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\t0\u0003:\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(\u001c\u0012\u0016\b\u0001\u0010\u001d\u001a\u00020\t:\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(\u001e\u0012\u0016\b\u0001\u0010\u001f\u001a\u00020 :\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(!\u0012\u001c\b\u0001\u0010\"\u001a\b\u0012\u0004\u0012\u00020#0\u0003:\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b($¢\u0006\u0004\b%\u0010&J\u000f\u00109\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003HÆ\u0003J\t\u0010:\u001a\u00020\tHÆ\u0003J\t\u0010;\u001a\u00020\tHÆ\u0003J\t\u0010<\u001a\u00020\tHÆ\u0003J\t\u0010=\u001a\u00020\u0010HÆ\u0003J\t\u0010>\u001a\u00020\u0013HÆ\u0003J\u000f\u0010?\u001a\b\u0012\u0004\u0012\u00020\u00160\u0003HÆ\u0003J\t\u0010@\u001a\u00020\u0019HÆ\u0003J\u000f\u0010A\u001a\b\u0012\u0004\u0012\u00020\t0\u0003HÆ\u0003J\t\u0010B\u001a\u00020\tHÆ\u0003J\t\u0010C\u001a\u00020 HÆ\u0003J\u000f\u0010D\u001a\b\u0012\u0004\u0012\u00020#0\u0003HÆ\u0003JÁ\u0002\u0010E\u001a\u00020\u00002\u001c\b\u0003\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003:\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(\u00072\u0016\b\u0003\u0010\b\u001a\u00020\t:\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(\n2\u0016\b\u0003\u0010\u000b\u001a\u00020\t:\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(\f2\u0016\b\u0003\u0010\r\u001a\u00020\t:\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(\u000e2\u0016\b\u0003\u0010\u000f\u001a\u00020\u0010:\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(\u00112\u0016\b\u0003\u0010\u0012\u001a\u00020\u0013:\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(\u00142\u001c\b\u0003\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00160\u0003:\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(\u00172\u0016\b\u0003\u0010\u0018\u001a\u00020\u0019:\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(\u001a2\u001c\b\u0003\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\t0\u0003:\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(\u001c2\u0016\b\u0003\u0010\u001d\u001a\u00020\t:\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(\u001e2\u0016\b\u0003\u0010\u001f\u001a\u00020 :\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(!2\u001c\b\u0003\u0010\"\u001a\b\u0012\u0004\u0012\u00020#0\u0003:\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b($HÆ\u0001J\u0014\u0010F\u001a\u00020G2\b\u0010H\u001a\u0004\u0018\u00010\u0001HÖ\u0083\u0004J\n\u0010I\u001a\u00020JHÖ\u0081\u0004J\n\u0010K\u001a\u00020\tHÖ\u0081\u0004R\u0017\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\b\n\u0000\u001a\u0004\b'\u0010(R\u0011\u0010\b\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b)\u0010*R\u0011\u0010\u000b\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b+\u0010*R\u0011\u0010\r\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b,\u0010*R\u0011\u0010\u000f\u001a\u00020\u0010¢\u0006\b\n\u0000\u001a\u0004\b-\u0010.R\u0011\u0010\u0012\u001a\u00020\u0013¢\u0006\b\n\u0000\u001a\u0004\b/\u00100R\u0017\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00160\u0003¢\u0006\b\n\u0000\u001a\u0004\b1\u0010(R\u0011\u0010\u0018\u001a\u00020\u0019¢\u0006\b\n\u0000\u001a\u0004\b2\u00103R\u0017\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\t0\u0003¢\u0006\b\n\u0000\u001a\u0004\b4\u0010(R\u0011\u0010\u001d\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b5\u0010*R\u0011\u0010\u001f\u001a\u00020 ¢\u0006\b\n\u0000\u001a\u0004\b6\u00107R\u0017\u0010\"\u001a\b\u0012\u0004\u0012\u00020#0\u0003¢\u0006\b\n\u0000\u001a\u0004\b8\u0010(¨\u0006L"}, d2 = {"Lcom/phisher98/MovieMetadata;", "", "people", "", "Lcom/phisher98/MovieMetadataPerson;", "Lcom/fasterxml/jackson/annotation/JsonProperty;", "value", "People", "name", "", "Name", "originalTitle", "OriginalTitle", "overview", "Overview", "productionYear", "", "ProductionYear", "providerIds", "Lcom/phisher98/ProviderIds;", "ProviderIds", "externalUrls", "Lcom/phisher98/ExternalUrl;", "ExternalUrls", "communityRating", "", "CommunityRating", "genres", "Genres", "id", "Id", "imageTags", "Lcom/phisher98/MovieMetadataImageTags;", "ImageTags", "remoteTrailers", "Lcom/phisher98/RemoteTrailer;", "RemoteTrailers", "<init>", "(Ljava/util/List;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;JLcom/phisher98/ProviderIds;Ljava/util/List;DLjava/util/List;Ljava/lang/String;Lcom/phisher98/MovieMetadataImageTags;Ljava/util/List;)V", "getPeople", "()Ljava/util/List;", "getName", "()Ljava/lang/String;", "getOriginalTitle", "getOverview", "getProductionYear", "()J", "getProviderIds", "()Lcom/phisher98/ProviderIds;", "getExternalUrls", "getCommunityRating", "()D", "getGenres", "getId", "getImageTags", "()Lcom/phisher98/MovieMetadataImageTags;", "getRemoteTrailers", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "component10", "component11", "component12", "copy", "equals", "", "other", "hashCode", "", "toString", "Jellyfin"}, k = 1, mv = {2, 4, 0}, xi = 48)
public final /* data */ class MovieMetadata {
    private final double communityRating;

    @NotNull
    private final List<ExternalUrl> externalUrls;

    @NotNull
    private final List<String> genres;

    @NotNull
    private final String id;

    @NotNull
    private final MovieMetadataImageTags imageTags;

    @NotNull
    private final String name;

    @NotNull
    private final String originalTitle;

    @NotNull
    private final String overview;

    @NotNull
    private final List<MovieMetadataPerson> people;
    private final long productionYear;

    @NotNull
    private final ProviderIds providerIds;

    @NotNull
    private final List<RemoteTrailer> remoteTrailers;

    @NotNull
    public final List<MovieMetadataPerson> component1() {
        return this.people;
    }

    @NotNull
    /* JADX INFO: renamed from: component10, reason: from getter */
    public final String getId() {
        return this.id;
    }

    @NotNull
    /* JADX INFO: renamed from: component11, reason: from getter */
    public final MovieMetadataImageTags getImageTags() {
        return this.imageTags;
    }

    @NotNull
    public final List<RemoteTrailer> component12() {
        return this.remoteTrailers;
    }

    @NotNull
    /* JADX INFO: renamed from: component2, reason: from getter */
    public final String getName() {
        return this.name;
    }

    @NotNull
    /* JADX INFO: renamed from: component3, reason: from getter */
    public final String getOriginalTitle() {
        return this.originalTitle;
    }

    @NotNull
    /* JADX INFO: renamed from: component4, reason: from getter */
    public final String getOverview() {
        return this.overview;
    }

    /* JADX INFO: renamed from: component5, reason: from getter */
    public final long getProductionYear() {
        return this.productionYear;
    }

    @NotNull
    /* JADX INFO: renamed from: component6, reason: from getter */
    public final ProviderIds getProviderIds() {
        return this.providerIds;
    }

    @NotNull
    public final List<ExternalUrl> component7() {
        return this.externalUrls;
    }

    /* JADX INFO: renamed from: component8, reason: from getter */
    public final double getCommunityRating() {
        return this.communityRating;
    }

    @NotNull
    public final List<String> component9() {
        return this.genres;
    }

    @NotNull
    public final MovieMetadata copy(@JsonProperty("People") @NotNull List<MovieMetadataPerson> people, @JsonProperty("Name") @NotNull String name, @JsonProperty("OriginalTitle") @NotNull String originalTitle, @JsonProperty("Overview") @NotNull String overview, @JsonProperty("ProductionYear") long productionYear, @JsonProperty("ProviderIds") @NotNull ProviderIds providerIds, @JsonProperty("ExternalUrls") @NotNull List<ExternalUrl> externalUrls, @JsonProperty("CommunityRating") double communityRating, @JsonProperty("Genres") @NotNull List<String> genres, @JsonProperty("Id") @NotNull String id, @JsonProperty("ImageTags") @NotNull MovieMetadataImageTags imageTags, @JsonProperty("RemoteTrailers") @NotNull List<RemoteTrailer> remoteTrailers) {
        return new MovieMetadata(people, name, originalTitle, overview, productionYear, providerIds, externalUrls, communityRating, genres, id, imageTags, remoteTrailers);
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof MovieMetadata)) {
            return false;
        }
        MovieMetadata movieMetadata = (MovieMetadata) other;
        return Intrinsics.areEqual(this.people, movieMetadata.people) && Intrinsics.areEqual(this.name, movieMetadata.name) && Intrinsics.areEqual(this.originalTitle, movieMetadata.originalTitle) && Intrinsics.areEqual(this.overview, movieMetadata.overview) && this.productionYear == movieMetadata.productionYear && Intrinsics.areEqual(this.providerIds, movieMetadata.providerIds) && Intrinsics.areEqual(this.externalUrls, movieMetadata.externalUrls) && Double.compare(this.communityRating, movieMetadata.communityRating) == 0 && Intrinsics.areEqual(this.genres, movieMetadata.genres) && Intrinsics.areEqual(this.id, movieMetadata.id) && Intrinsics.areEqual(this.imageTags, movieMetadata.imageTags) && Intrinsics.areEqual(this.remoteTrailers, movieMetadata.remoteTrailers);
    }

    public int hashCode() {
        return (((((((((((((((((((((this.people.hashCode() * 31) + this.name.hashCode()) * 31) + this.originalTitle.hashCode()) * 31) + this.overview.hashCode()) * 31) + MovieMetadata$$ExternalSyntheticBackport0.m3m(this.productionYear)) * 31) + this.providerIds.hashCode()) * 31) + this.externalUrls.hashCode()) * 31) + MovieMetadata$$ExternalSyntheticBackport1.m4m(this.communityRating)) * 31) + this.genres.hashCode()) * 31) + this.id.hashCode()) * 31) + this.imageTags.hashCode()) * 31) + this.remoteTrailers.hashCode();
    }

    @NotNull
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("MovieMetadata(people=").append(this.people).append(", name=").append(this.name).append(", originalTitle=").append(this.originalTitle).append(", overview=").append(this.overview).append(", productionYear=").append(this.productionYear).append(", providerIds=").append(this.providerIds).append(", externalUrls=").append(this.externalUrls).append(", communityRating=").append(this.communityRating).append(", genres=").append(this.genres).append(", id=").append(this.id).append(", imageTags=").append(this.imageTags).append(", remoteTrailers=");
        sb.append(this.remoteTrailers).append(')');
        return sb.toString();
    }

    public MovieMetadata(@JsonProperty("People") @NotNull List<MovieMetadataPerson> list, @JsonProperty("Name") @NotNull String name, @JsonProperty("OriginalTitle") @NotNull String originalTitle, @JsonProperty("Overview") @NotNull String overview, @JsonProperty("ProductionYear") long productionYear, @JsonProperty("ProviderIds") @NotNull ProviderIds providerIds, @JsonProperty("ExternalUrls") @NotNull List<ExternalUrl> list2, @JsonProperty("CommunityRating") double communityRating, @JsonProperty("Genres") @NotNull List<String> list3, @JsonProperty("Id") @NotNull String id, @JsonProperty("ImageTags") @NotNull MovieMetadataImageTags imageTags, @JsonProperty("RemoteTrailers") @NotNull List<RemoteTrailer> list4) {
        this.people = list;
        this.name = name;
        this.originalTitle = originalTitle;
        this.overview = overview;
        this.productionYear = productionYear;
        this.providerIds = providerIds;
        this.externalUrls = list2;
        this.communityRating = communityRating;
        this.genres = list3;
        this.id = id;
        this.imageTags = imageTags;
        this.remoteTrailers = list4;
    }

    /* JADX WARN: Illegal instructions before constructor call */
    public /* synthetic */ MovieMetadata(List list, String str, String str2, String str3, long j, ProviderIds providerIds, List list2, double d, List list3, String str4, MovieMetadataImageTags movieMetadataImageTags, List list4, int i, DefaultConstructorMarker defaultConstructorMarker) {
        List listEmptyList;
        if ((i & 1) == 0) {
            listEmptyList = list;
        } else {
            listEmptyList = CollectionsKt.emptyList();
        }
        this(listEmptyList, str, str2, str3, j, providerIds, list2, d, list3, str4, movieMetadataImageTags, list4);
    }

    @NotNull
    public final List<MovieMetadataPerson> getPeople() {
        return this.people;
    }

    @NotNull
    public final String getName() {
        return this.name;
    }

    @NotNull
    public final String getOriginalTitle() {
        return this.originalTitle;
    }

    @NotNull
    public final String getOverview() {
        return this.overview;
    }

    public final long getProductionYear() {
        return this.productionYear;
    }

    @NotNull
    public final ProviderIds getProviderIds() {
        return this.providerIds;
    }

    @NotNull
    public final List<ExternalUrl> getExternalUrls() {
        return this.externalUrls;
    }

    public final double getCommunityRating() {
        return this.communityRating;
    }

    @NotNull
    public final List<String> getGenres() {
        return this.genres;
    }

    @NotNull
    public final String getId() {
        return this.id;
    }

    @NotNull
    public final MovieMetadataImageTags getImageTags() {
        return this.imageTags;
    }

    @NotNull
    public final List<RemoteTrailer> getRemoteTrailers() {
        return this.remoteTrailers;
    }
}
