package com.IStreamFlare;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: IStreamFlareParser.kt */
/* JADX INFO: loaded from: /home/runner/work/NepaliStream-CNC-Repo/NepaliStream-CNC-Repo/decoded/IStreamFlare/Phisher98/java/classes.dex */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0019\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B[\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\n\u0010\u000bJ\u000b\u0010\u0014\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0015\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0016\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0017\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0018\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0019\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u001a\u001a\u0004\u0018\u00010\u0003HÆ\u0003J]\u0010\u001b\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\u0014\u0010\u001c\u001a\u00020\u001d2\b\u0010\u001e\u001a\u0004\u0018\u00010\u0001HÖ\u0083\u0004J\n\u0010\u001f\u001a\u00020 HÖ\u0081\u0004J\n\u0010!\u001a\u00020\u0003HÖ\u0081\u0004R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\rR\u0013\u0010\u0005\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\rR\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\rR\u0013\u0010\u0007\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\rR\u0013\u0010\b\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\rR\u0013\u0010\t\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\r¨\u0006\""}, d2 = {"Lcom/IStreamFlare/CustomTag;", "", "background_color", "", "content_id", "content_type", "custom_tags_id", "custom_tags_name", "id", "text_color", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getBackground_color", "()Ljava/lang/String;", "getContent_id", "getContent_type", "getCustom_tags_id", "getCustom_tags_name", "getId", "getText_color", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "copy", "equals", "", "other", "hashCode", "", "toString", "IStreamFlare"}, k = 1, mv = {2, 4, 0}, xi = 48)
public final /* data */ class CustomTag {

    @Nullable
    private final String background_color;

    @Nullable
    private final String content_id;

    @Nullable
    private final String content_type;

    @Nullable
    private final String custom_tags_id;

    @Nullable
    private final String custom_tags_name;

    @Nullable
    private final String id;

    @Nullable
    private final String text_color;

    public CustomTag() {
        this(null, null, null, null, null, null, null, 127, null);
    }

    public static /* synthetic */ CustomTag copy$default(CustomTag customTag, String str, String str2, String str3, String str4, String str5, String str6, String str7, int i, Object obj) {
        if ((i & 1) != 0) {
            str = customTag.background_color;
        }
        if ((i & 2) != 0) {
            str2 = customTag.content_id;
        }
        if ((i & 4) != 0) {
            str3 = customTag.content_type;
        }
        if ((i & 8) != 0) {
            str4 = customTag.custom_tags_id;
        }
        if ((i & 16) != 0) {
            str5 = customTag.custom_tags_name;
        }
        if ((i & 32) != 0) {
            str6 = customTag.id;
        }
        if ((i & 64) != 0) {
            str7 = customTag.text_color;
        }
        String str8 = str6;
        String str9 = str7;
        String str10 = str5;
        String str11 = str3;
        return customTag.copy(str, str2, str11, str4, str10, str8, str9);
    }

    @Nullable
    /* JADX INFO: renamed from: component1, reason: from getter */
    public final String getBackground_color() {
        return this.background_color;
    }

    @Nullable
    /* JADX INFO: renamed from: component2, reason: from getter */
    public final String getContent_id() {
        return this.content_id;
    }

    @Nullable
    /* JADX INFO: renamed from: component3, reason: from getter */
    public final String getContent_type() {
        return this.content_type;
    }

    @Nullable
    /* JADX INFO: renamed from: component4, reason: from getter */
    public final String getCustom_tags_id() {
        return this.custom_tags_id;
    }

    @Nullable
    /* JADX INFO: renamed from: component5, reason: from getter */
    public final String getCustom_tags_name() {
        return this.custom_tags_name;
    }

    @Nullable
    /* JADX INFO: renamed from: component6, reason: from getter */
    public final String getId() {
        return this.id;
    }

    @Nullable
    /* JADX INFO: renamed from: component7, reason: from getter */
    public final String getText_color() {
        return this.text_color;
    }

    @NotNull
    public final CustomTag copy(@Nullable String background_color, @Nullable String content_id, @Nullable String content_type, @Nullable String custom_tags_id, @Nullable String custom_tags_name, @Nullable String id, @Nullable String text_color) {
        return new CustomTag(background_color, content_id, content_type, custom_tags_id, custom_tags_name, id, text_color);
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof CustomTag)) {
            return false;
        }
        CustomTag customTag = (CustomTag) other;
        return Intrinsics.areEqual(this.background_color, customTag.background_color) && Intrinsics.areEqual(this.content_id, customTag.content_id) && Intrinsics.areEqual(this.content_type, customTag.content_type) && Intrinsics.areEqual(this.custom_tags_id, customTag.custom_tags_id) && Intrinsics.areEqual(this.custom_tags_name, customTag.custom_tags_name) && Intrinsics.areEqual(this.id, customTag.id) && Intrinsics.areEqual(this.text_color, customTag.text_color);
    }

    public int hashCode() {
        return ((((((((((((this.background_color == null ? 0 : this.background_color.hashCode()) * 31) + (this.content_id == null ? 0 : this.content_id.hashCode())) * 31) + (this.content_type == null ? 0 : this.content_type.hashCode())) * 31) + (this.custom_tags_id == null ? 0 : this.custom_tags_id.hashCode())) * 31) + (this.custom_tags_name == null ? 0 : this.custom_tags_name.hashCode())) * 31) + (this.id == null ? 0 : this.id.hashCode())) * 31) + (this.text_color != null ? this.text_color.hashCode() : 0);
    }

    @NotNull
    public String toString() {
        return "CustomTag(background_color=" + this.background_color + ", content_id=" + this.content_id + ", content_type=" + this.content_type + ", custom_tags_id=" + this.custom_tags_id + ", custom_tags_name=" + this.custom_tags_name + ", id=" + this.id + ", text_color=" + this.text_color + ')';
    }

    public CustomTag(@Nullable String background_color, @Nullable String content_id, @Nullable String content_type, @Nullable String custom_tags_id, @Nullable String custom_tags_name, @Nullable String id, @Nullable String text_color) {
        this.background_color = background_color;
        this.content_id = content_id;
        this.content_type = content_type;
        this.custom_tags_id = custom_tags_id;
        this.custom_tags_name = custom_tags_name;
        this.id = id;
        this.text_color = text_color;
    }

    public /* synthetic */ CustomTag(String str, String str2, String str3, String str4, String str5, String str6, String str7, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? null : str, (i & 2) != 0 ? null : str2, (i & 4) != 0 ? null : str3, (i & 8) != 0 ? null : str4, (i & 16) != 0 ? null : str5, (i & 32) != 0 ? null : str6, (i & 64) != 0 ? null : str7);
    }

    @Nullable
    public final String getBackground_color() {
        return this.background_color;
    }

    @Nullable
    public final String getContent_id() {
        return this.content_id;
    }

    @Nullable
    public final String getContent_type() {
        return this.content_type;
    }

    @Nullable
    public final String getCustom_tags_id() {
        return this.custom_tags_id;
    }

    @Nullable
    public final String getCustom_tags_name() {
        return this.custom_tags_name;
    }

    @Nullable
    public final String getId() {
        return this.id;
    }

    @Nullable
    public final String getText_color() {
        return this.text_color;
    }
}
